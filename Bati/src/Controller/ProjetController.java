package Controller;

import Metier.Client;
import Metier.Projet;
import Service.ProjetService;

public class ProjetController {
    private final ProjetService projetService;
    private final ClientController clientController;

    public ProjetController(ProjetService projetService, ClientController clientController) {
        this.projetService = projetService;
        this.clientController = clientController;
    }

    public Projet creerProjet(String nomProjet, double margeBeneficiaire, String nomClient, String adresseClient,
                              String telephoneClient, boolean estProfessionnel) {


        Client clientExistant = clientController.getClientByName(nomClient);


        if (clientExistant == null) {
            clientController.ajouterClient(adresseClient, nomClient, telephoneClient, estProfessionnel);


            clientExistant = clientController.getClientByName(nomClient);
            if (clientExistant == null) {
                System.out.println("Erreur : La création du client a échoué. Impossible d'associer le client au projet.");
                return null;
            }
        }

        Projet projet = new Projet();


   return null;
    }
}




