import Controller.ClientController;
import Metier.Client;
import Metier.Projet;
import Repository.ClientRepository;
import Repository.ProjetRepository;
import Service.ClientService;

public class Main {

    public static void main(String[] args) {


        ClientRepository clientRepo = new ClientRepository();


        Client client = clientRepo.getClientById(4);

        System.out.println(client.getId());


        if (client != null) {
            System.out.println("Client trouvé : " + client.getNom());

            // Créer un nouvel objet Projet
            Projet projet = new Projet();
            projet.setNomProjet("Construction Maison Moderne");
            projet.setMargeBeneficiaire(15.5); // marge bénéficiaire en pourcentage
            projet.setCoutTotal(200000); // coût total estimé
            projet.setEtatProjet("En cours");

            // Associer le client récupéré au projet
            projet.setClient(client);

            // Initialiser le repository pour gérer les projets
            ProjetRepository projetRepo = new ProjetRepository();

            // Ajouter le projet à la base de données
            projetRepo.ajouterProjet(projet);

            System.out.println("Projet ajouté avec succès pour le client : " + client.getNom());

        } else {
            System.out.println("Aucun client trouvé avec l'ID 1.");
        }
    }


    }


