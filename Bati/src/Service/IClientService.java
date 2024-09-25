package Service;

import Metier.Client;

import java.util.List;

public interface IClientService {
    Client ajouterClient(Client client);

    Client getClientById(long id);

    Client getClientByName(String name);

    List<Client> getAllClients();
}
