package Service;

import Repository.ClientRepository;
import Metier.Client;

import java.util.List;

public class ClientService  implements  IClientService{

    private final ClientRepository Clientad;


    public ClientService() {

        this.Clientad = new ClientRepository();
    }


    @Override
    public void ajouterClient(Client client) {
        Clientad.ajouterClient(client);
    }

    @Override
    public Client getClientById(long id) {
       return Clientad.getClientById(id);
    }

    @Override
    public Client getClientByName(String name) {
        return Clientad.getClientByName(name);
    }

    @Override
    public List<Client> getAllClients() {
        return  Clientad.getAllClients();
    }
}
