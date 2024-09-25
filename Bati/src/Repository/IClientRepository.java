package Repository;

import Metier.Client;

import java.util.List;

public interface IClientRepository {
    public Client ajouterClient(Client client);
    Client getClientByName(String name);
    Client getClientById(long id);
    public List<Client> getAllClients();

}
