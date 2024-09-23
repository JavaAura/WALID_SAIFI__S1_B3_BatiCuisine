package Service;

import Repository.ClientRepository;
import Metier.Client;

import java.util.List;

public class ClientService  implements  IClientService{
    private ClientRepository Clientad;


    public ClientService() {

        this.Clientad = new ClientRepository();
    }


    @Override
    public void ajouterClient(Client client) {
        Clientad.ajouterClient(client);
    }

    @Override
    public Client getClientById(Long id) {
        return null;
    }

    @Override
    public Client getClientByName(String name) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return List.of();
    }
}
