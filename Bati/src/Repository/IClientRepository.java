package Repository;

import Metier.Client;

public interface IClientRepository {
    public void ajouterClient(Client client);
    public Client getClientById(int id);
}
