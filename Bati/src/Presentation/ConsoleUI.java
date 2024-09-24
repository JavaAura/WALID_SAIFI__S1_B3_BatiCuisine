package Presentation;
import Controller.ClientController;
import Controller.ComposantController;
import Controller.DevisController;
import Controller.ProjetController;
import Metier.Client;
import Metier.Projet;

import  java.util.*;

public class ConsoleUI {

    private final ProjetController projetController;
    private final DevisController devisController;
    private final ClientController clientController;
    private final ComposantController composantController;



    private final Map<Long, Client> clientCache = new HashMap<>();


    public ConsoleUI(ProjetController projetController, DevisController devisController,
                     ClientController clientController, ComposantController composant) {
        this.projetController = projetController;
        this.devisController = devisController;
        this.clientController = clientController;
        this.composantController = composant;
    }

    public void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Menu:");
            System.out.println("1. Créer un nouveau projet");
            System.out.println("2. Afficher les projets existants");
            System.out.println("3. Calculer le coût d'un projet");
            System.out.println("4. Quitter");
            System.out.print("Veuillez choisir une option (1-4): ");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    // Appel à la méthode pour créer un nouveau projet
                   // creerNouveauProjet(scanner);
                    break;
                case 2:
                    // Appel à la méthode pour afficher les projets existants
                   // afficherProjetsExistants();
                    break;
                case 3:
                    // Appel à la méthode pour calculer le coût d'un projet
                   // calculerCoutProjet(scanner);
                    break;
                case 4:
                    System.out.println("Merci d'avoir utilisé l'application. À bientôt!");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 4);

        scanner.close();
    }


    public Client getClient(Scanner scanner) {
        System.out.println("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
        System.out.println("1. Chercher un client existant\n2. Ajouter un nouveau client\nChoisissez une option : ");

        int choixClient;
        while (true) {
            try {
                choixClient = Integer.parseInt(scanner.nextLine());
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
            System.out.print("Entrez le nom du client à rechercher: ");
            String nomClient = scanner.nextLine();
            client = clientController.getClientByName(nomClient);
            if (client != null) {
                System.out.println("Client trouvé: " + client.toString());
                return client;
            } else {
                System.out.println("Client non trouvé.");
            }
        } else if (choixClient == 2) {
            System.out.print("Entrez le nom du nouveau client: ");
            String nomClient = scanner.nextLine();

            System.out.print("Entrez l'adresse du client: ");
            String adresse = scanner.nextLine();

            System.out.print("Entrez le téléphone du client: ");
            String telephone = scanner.nextLine();

            System.out.println("Sélectionnez le type de client :");
            System.out.println("1. Client Professionnel");
            System.out.println("2. Client Particulier");

            boolean estProfessionnel = false;
            int typeClient;

            while (true) {
                try {
                    typeClient = Integer.parseInt(scanner.nextLine());
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

            client = new Client(adresse, nomClient, telephone, estProfessionnel);
            clientController.ajouterClient(adresse, nomClient, telephone, estProfessionnel);
            System.out.println("Client ajouté");
        }

        return client;
    }





    public void creerNouveauProjet(Scanner scanner) {
        System.out.println("--- Recherche de client ---");
        Client client = getClient(scanner); // Assurez-vous que getClient renvoie le client
        scanner.nextLine(); // Consomme la ligne restante après l'appel de getClient

        System.out.println("--- Création d'un Nouveau Projet ---");
        System.out.print("Entrez le nom du projet: ");
        String nomProjet = scanner.nextLine();

        System.out.print("Entrez la marge bénéficiaire (%): ");
        double margeBeneficiaire = scanner.nextDouble();

        System.out.print("Entrez la surface de la cuisine (en m²): ");
        double surface = scanner.nextDouble();


       // Projet projet = new Projet(nomProjet, margeBeneficiaire, surface);


        boolean ajouterMateriaux = true;
        while (ajouterMateriaux) {
            System.out.print("Voulez-vous ajouter un matériau ? (y/n): ");
            ajouterMateriaux = scanner.next().equalsIgnoreCase("y");
            if (ajouterMateriaux) {
                System.out.print("Entrez le nom du matériau: ");
                String nomMateriau = scanner.next();

            }
        }


        System.out.println("Projet créé avec succès !");
    }


}
