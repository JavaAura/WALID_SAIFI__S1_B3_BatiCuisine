package Controller;

import Metier.Client;
import Service.ClientService;

public class ClientController {
    private final ClientService clientService;




    public ClientController(ClientService clientService) {

        if (clientService == null) {
            throw new IllegalArgumentException("ClientService ne peut pas être null");
        }
        this.clientService = clientService;
    }

    public void ajouterClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client ne peut pas être null");
        }
        clientService.ajouterClient(client);
    }


}
