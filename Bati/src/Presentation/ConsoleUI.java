package Presentation;
import Controller.ClientController;
import Controller.ComposantController;
import Controller.DevisController;
import Controller.ProjetController;
import Metier.Client;
import Metier.MainOeuvre;
import Metier.Materiel;
import Metier.Projet;
import Service.MaterielService;
import Service.DevisService;
import Service.MainOeuvreService;
import Controller.MaterielController;
import Controller.MainOeuvreController;
import Repository.MainOeuvreRepository;
import Repository.MaterielRepository;
import Repository.DevisRepository;
import Metier.Devis;
import util.validationInput;

import java.util.*;

import java.time.LocalDate;

public class ConsoleUI {

    private ProjetController projetController;
    private MaterielService materielService;
    private MainOeuvreService mainOeuvreService;
    private MaterielController materielController;
    private MainOeuvreController mainOeuvreController;
    private ClientController clientController;
    private ComposantController composantController;
    private MainOeuvreRepository mainOeuvreRepository;
    private MaterielRepository materielRepository;
    private DevisController devisController;
    private DevisService devisService;
    private DevisRepository devisRepository;
    private Scanner scanner;



    public ConsoleUI() {

        this.scanner = new Scanner(System.in);
        this.projetController = new ProjetController();
        this.clientController = new ClientController();
        this.composantController = new ComposantController();
        this.mainOeuvreRepository = new MainOeuvreRepository();
        this.materielRepository = new MaterielRepository();
        this.materielService = new MaterielService(materielRepository);
        this.mainOeuvreService = new MainOeuvreService(mainOeuvreRepository);
        this.materielController = new MaterielController(materielService);
        this.mainOeuvreController = new MainOeuvreController(mainOeuvreService);
        this.devisRepository = new DevisRepository();
        this.devisService = new DevisService(devisRepository);
        this.devisController = new DevisController(devisService);
        
        


    }


    public void afficherMenu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Créer un nouveau projet");
            System.out.println("2. Afficher les projets existants");
            System.out.println("3. Calculer le coût d'un projet");
            System.out.println("4. Quitter");
            System.out.print("Veuillez choisir une option (1-4): ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine();
                switch (choix) {
                    case 1:
                        creerNouveauProjet(scanner);
                        break;
                    case 2:
                       afficherProjetsExistants();
                        break;
                    case 3:
                        calculerCoutProjet();
                        break;
                    case 4:
                        System.out.println("Au revoir !");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Option invalide, veuillez choisir entre 1 et 4.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Veuillez entrer un nombre valide.");
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Erreur : Aucune entrée trouvée. Veuillez réessayer.");
                break;
            }
        }
    }




    public Client getClient() {
        System.out.println("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
        System.out.println("1. Chercher un client existant\n2. Ajouter un nouveau client\nChoisissez une option : ");

        int choixClient;
        Scanner scanner = this.scanner;

        choixClient = scanner.nextInt();
        while (true) {
            try {

                if (choixClient == 1 || choixClient == 2) {
                    break;
                } else {
                    System.out.println("Choix invalide. Veuillez entrer 1 ou 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

        Client client = null;
        if (choixClient == 1) {
            scanner.nextLine();
            System.out.print("Entrez le nom du client à rechercher:\n ");
            String nomClient =validationInput.validationChaine(scanner);
            client = clientController.getClientByName(nomClient);
            if (client != null) {
                System.out.println("Client trouvé: " + client.toString());
                return client;
            } else {
                System.out.println("Client non trouvé.");
            }
        } else if (choixClient == 2) {
             client=ajouterClient();
        }

        return client;
    }





    public void creerNouveauProjet(Scanner scanner) {
        System.out.println("--- Recherche de client ---");
        Client client = getClient();

        System.out.println("Client sélectionné: " + client.getNom());

        System.out.println("--- Création d'un Nouveau Projet ---");
        System.out.print("Entrez le nom du projet:\n ");
        String nomProjet = validationInput.validationChaine(scanner);

        System.out.print("Entrez la surface de la cuisine (en m²): \n");
        double surface = validationInput.validationDouble(scanner);
        List<Materiel> materiels = addMateriel();
        List<MainOeuvre> mainOeuvres = addMainOeuvre();
        double coutTotalMateriel = materiels.stream()
                .mapToDouble(Materiel::calculerCoutTotal)
                .sum();
        double coutTotalMainOeuvre = mainOeuvres.stream()
                .mapToDouble(MainOeuvre::calculerCoutTotal)
                .sum();
        System.out.print("Entrez la marge bénéficiaire (%): ");
        double margeBeneficiaire = validationInput.validationDouble(scanner);
        double coutTotal = (coutTotalMateriel + coutTotalMainOeuvre)*(1+margeBeneficiaire/100);
        System.out.println("Le cout total des matériaux est de: " + coutTotalMateriel);
        System.out.println("Le cout total des main-d'oeuvre est de: " + coutTotalMainOeuvre);
        System.out.println("Le cout total du projet est de: " + coutTotal);

      
        Projet projet = new Projet(nomProjet,surface, client,coutTotal,margeBeneficiaire);

        Projet projetAjouter = projetController.creerProjet(projet);
        materiels.forEach(materiel -> materiel.setProjet(projetAjouter));
        mainOeuvres.forEach(mainOeuvre -> mainOeuvre.setProjet(projetAjouter));

        materielController.ajouterListeMateriaux(materiels);
        mainOeuvreController.ajouterListeMainOeuvre(mainOeuvres);

        System.out.println("Projet créé avec succès !");
        System.out.println("Le projet est : " + projetAjouter.getNomProjet());
        ajouterDevis(projet);
    }

    public List<Materiel> addMateriel() {
        List<Materiel> materiels = new ArrayList<>();
        boolean continueAdding = true;

        while (continueAdding) {
            System.out.println("--- Ajout d'un nouveau matériel ---");
            System.out.print("Entrez le nom du matériau: ");
            String nomMateriau =validationInput.validationChaine(scanner);
            System.out.print("Entrez la quantité de matériau: ");
            double quantite = validationInput.validationDouble(scanner);
            System.out.print("Entrez le coût unitaire du matériau: ");
            double coutUnitaire = validationInput.validationDouble(scanner);
            System.out.print("Entrez le coût de transport du matériau: ");
            double coutTransport = validationInput.validationDouble(scanner);
            System.out.print("Entrez le coefficient de qualité du matériau: ");
            double coefficientQualite = validationInput.validationDouble(scanner);
            System.out.print("Entrez le taux de TVA du matériau: ");
            double tauxTVA = scanner.nextDouble();

            Materiel materiel = new Materiel(nomMateriau, tauxTVA, coutUnitaire, quantite, coutTransport, coefficientQualite);
            materiels.add(materiel);

            System.out.print("Voulez-vous ajouter un autre matériau ? (o/n): ");
            String response = scanner.next().toLowerCase();
            continueAdding = response.equals("o") || response.equals("oui");
        }

        return materiels;
    }

    public List<MainOeuvre> addMainOeuvre() {
        List<MainOeuvre> mainOeuvres = new ArrayList<>();
        boolean continueAdding = true;

        while (continueAdding) {
            System.out.println("--- Ajout d'une nouvelle main-d'oeuvre ---");
            System.out.print("Entrez le nom du travailleur: ");
            String nomTravailleur = validationInput.validationChaine(scanner);
            System.out.print("Entrez le taux horaire du travailleur: ");
            double tauxHoraire = validationInput.validationDouble(scanner);
            System.out.print("Entrez le nombre d'heures de travail du travailleur: ");
            double heuresTravail = validationInput.validationDouble(scanner);
            System.out.print("Entrez la productivité du travailleur: ");
            double productiviteOuvrier = validationInput.validationDouble(scanner);
            System.out.print("Entrez le taux de TVA du travailleur: ");
            double tauxTVA = validationInput.validationDouble(scanner);
            MainOeuvre mainOeuvre = new MainOeuvre(nomTravailleur, tauxHoraire, heuresTravail, productiviteOuvrier, tauxTVA);
            mainOeuvres.add(mainOeuvre);

            System.out.print("Voulez-vous ajouter un autre travailleur ? (o/n): ");
            String response = scanner.next().toLowerCase();
            continueAdding = response.equals("o") || response.equals("oui");
        }
        return mainOeuvres;
        }
    
    


    public  Client ajouterClient(){
        scanner.nextLine();
        System.out.print("Entrez le nom du nouveau client: ");
        String nomClient = this.scanner.nextLine();
        System.out.print("Entrez l'adresse du client: ");
        String adresse = this.scanner.nextLine();
        System.out.print("Entrez le téléphone du client: ");
        String telephone = this.scanner.nextLine();
        System.out.println("Sélectionnez le type de client :");
        System.out.println("1. Client Professionnel");
        System.out.println("2. Client Particulier");

        boolean estProfessionnel = false;
        int typeClient;

        while (true) {
            try {
                typeClient = Integer.parseInt(this.scanner.nextLine());
                if (typeClient == 1) {
                    estProfessionnel = true;
                    break;
                } else if (typeClient == 2) {
                    estProfessionnel = false;
                    break;
                } else {
                    System.out.println("Choix invalide. Veuillez entrer 1 ou 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

        Client newclient = new Client(adresse, nomClient, telephone, estProfessionnel);
        System.out.println(newclient.getNom());
        Client cltAjouter  = clientController.ajouterClient(newclient);
        System.out.println("Client ajouté");
        return  cltAjouter;
    }







    public void ajouterDevis(Projet projet) {
        try (Scanner scanner = new Scanner(System.in)) {
            Double montantEstime = projet.getCoutTotal();
            System.out.println("Le devis a été émis à la date : " + LocalDate.now());

            LocalDate dateValidite = validationInput.validationDate(scanner);

            System.out.println("Le devis est-il accepté ? (o/n) : ");
            boolean accepte;
            while (true) {
                String reponse = scanner.nextLine().trim().toLowerCase();
                if (reponse.equals("o")) {
                    accepte = true;
                    break;
                } else if (reponse.equals("n")) {
                    accepte = false;
                    break;
                } else {
                    System.out.println("Veuillez entrer 'o' pour oui ou 'n' pour non : ");
                }
            }

            // Création d'un objet Devis avec les informations saisies
            Devis devis = new Devis(montantEstime, LocalDate.now(), dateValidite, accepte, projet);

            // Ajout du devis via le contrôleur
            devisController.ajouterDevis(devis);
        }
    }

    private void afficherProjetsExistants() {

        List<Projet> projets = projetController.obtenirTousLesProjets();

        if (projets.isEmpty()) {
            System.out.println("Aucun projet existant à afficher.\n");
        } else {
            System.out.print("---------------------------------------------Liste des projets existants :\n --------------------------------");
            for (Projet projet : projets) {
                System.out.print("ID: " + projet.getId() +
                        ", Nom: " + projet.getNomProjet() +
                        ", Marge Bénéficiaire: " + projet.getMargeBeneficiaire() +
                        ", Coût Total: " + projet.getCoutTotal() +
                        ", État: " + projet.getEtatProjet() + " |\n");
                System.out.println("-------------------------------------------------------------------------------------------------------------");
            }

        }
    }



    private void calculerCoutProjet() {
        System.out.print("Veuillez entrer le nom du projet :\n ");

        try {
            String nomProjet = validationInput.validationChaine(scanner);


            Projet projet = projetController.obtenirProjetParNom(nomProjet);

            if (projet != null) {

                System.out.println("Le coût total du projet \"" + projet.getNomProjet() + "\" est : " + projet.getCoutTotal());
            } else {
                System.out.println("Aucun projet trouvé avec le nom : " + nomProjet);
            }

        } catch (InputMismatchException e) {
            System.err.println("Erreur de saisie : Veuillez entrer un nom valide.");
        } catch (Exception e) {
            System.err.println("Une erreur est survenue : " + e.getMessage());
        }

    }


}


