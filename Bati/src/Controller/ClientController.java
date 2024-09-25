package Controller;

import Metier.Client;
import Service.ClientService;

public class ClientController {

    private ClientService clientService;

    public ClientController() {
        this.clientService = new ClientService();
    }

    public Client ajouterClient(Client client) {

        if (clientService == null) {
            throw new IllegalStateException("ClientService n'a pas été initialisé.");
        }

        Client clientajt = clientService.ajouterClient(client);
        return clientajt;
    }

    public Client getClientById(Long id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            System.out.println("Client trouvé ! : " + client.getNom());
        } else {
            System.out.println("Aucun client trouvé avec l'ID : " + id);
        }
        return client;
    }

    public Client getClientByName(String name) {
        Client client = clientService.getClientByName(name);
        if (client != null) {
            System.out.println("Client trouvé ! : " + client.getNom());
        } else {
            System.out.println("Aucun client trouvé avec le nom :" + name);
        }
        return client;
    }
}
