package Repository;

import Metier.Client;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IClientRepository {

     @Override

    public Client ajouterClient(Client client) {
        String sql = "INSERT INTO Client(nom, adresse, telephone, estProfessionnel) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getAdresse());
            stmt.setString(3, client.getTelephone());
            stmt.setBoolean(4, client.isEstProfessionnel());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        client.setId(generatedKeys.getLong(1));
                    }
                }
                System.out.println("Client ajouté avec succès.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du client : " + e.getMessage());
        }

        return client;
    }

    @Override
    public Client getClientByName(String name) {
        String sql = "SELECT * FROM Client WHERE nom = ?";
        Client client = null;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                long id = rs.getLong("id");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                boolean estProfessionnel = rs.getBoolean("estProfessionnel");

                client = new Client(id, adresse, name, telephone, estProfessionnel);
            } else {
                System.out.println("Aucun client trouvé avec le nom : " + name);
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du client : " + e.getMessage());
        }

        return client;
    }



    @Override
    public Client getClientById(long id) {
        String sql = "SELECT * FROM Client WHERE id = ?";
        Client client = null;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                long Id = rs.getLong("id");
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                boolean estProfessionnel = rs.getBoolean("estProfessionnel");


                client = new Client(Id,adresse, nom, telephone, estProfessionnel);
            } else {
                System.out.println("Aucun client trouvé avec l'ID : " + id);
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du client : " + e.getMessage());
        }
        System.out.println(client.getId());
        return client;
    }





    @Override
    public List<Client> getAllClients() {
        String sql = "SELECT * FROM Client";
        List<Client> clients = new ArrayList<>();

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                boolean estProfessionnel = rs.getBoolean("estProfessionnel");

                Client client = new Client(id, adresse, nom, telephone, estProfessionnel);
                clients.add(client);
            }

            if (clients.isEmpty()) {
                System.out.println("Aucun client trouvé.");
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des clients : " + e.getMessage());
        }

        return clients;
    }


}
