package Controller;

import Metier.Client;
import Service.ClientService;

public class ClientController {

    private  ClientService clientService;


    public ClientController(ClientService clientService) {

        this.clientService = clientService;
    }

    public void ajouterClient(String adresse, String nom, String telephone, boolean estProfessionnel) {

        Client client = new Client();
        client.setAdresse(adresse);
        client.setNom(nom);
        client.setTelephone(telephone);
        client.setEstProfessionnel(estProfessionnel);

        double remise = 0.0;

        if (estProfessionnel) {
            remise = calculerRemiseProfessionnelle(client);
            System.out.println("C'est un client professionnel. Remise appliquée : " + remise + "%");
        } else {
            System.out.println("C'est un client régulier.");
        }
        clientService.ajouterClient(client);
    }

    private double calculerRemiseProfessionnelle(Client client) {
        return 10.0;
    }


    public Client getClientById(Long id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            System.out.println("Client nom trouvé ! : " + client.getNom());
        } else {
            System.out.println("Aucun client trouvé avec le nom : " + id);
        }
        return client;
    }

    public Client getClientByName(String name) {
        Client client = clientService.getClientByName(name);
        if (client != null) {
            System.out.println("Client nom trouvé ! : " + client.getNom());
        } else {
            System.out.println("Aucun client trouvé avec le nom :" + name);
        }
        return client;
    }

}
