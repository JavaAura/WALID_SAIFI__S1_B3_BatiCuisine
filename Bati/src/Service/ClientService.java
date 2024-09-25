package Service;

import Repository.ClientRepository;
import Metier.Client;

import java.util.List;

public class ClientService implements IClientService {

    private ClientRepository clientRepository;  // Utilisez un nom cohérent en minuscules

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    @Override
    public Client ajouterClient(Client client) {
        System.out.println(client.getNom());
        return clientRepository.ajouterClient(client);
    }

    @Override
    public Client getClientById(long id) {
        return clientRepository.getClientById(id);
    }

    @Override
    public Client getClientByName(String name) {
        return clientRepository.getClientByName(name);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }
}
