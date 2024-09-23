package Repository;

import Metier.Client;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRepository implements IClientRepository {

     @Override

    public void ajouterClient(Client client) {
        String sql = "INSERT INTO Client(nom, adresse, telephone, estProfessionnel) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, client.getNom());
            stmt.setString(2, client.getAdresse());
            stmt.setString(3, client.getTelephone());
            stmt.setBoolean(4, client.isEstProfessionnel());

            stmt.executeUpdate();
            System.out.println("Client ajouté avec succès.");

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du client : " + e.getMessage());
        }
    }



    @Override
    public Client getClientById(Long id) {
        String sql = "SELECT * FROM Client WHERE id = ?";
        Client client = null;

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                String telephone = rs.getString("telephone");
                boolean estProfessionnel = rs.getBoolean("estProfessionnel");

                // Créer l'objet Client avec les informations récupérées
                client = new Client(adresse, nom, telephone, estProfessionnel);
            } else {
                System.out.println("Aucun client trouvé avec l'ID : " + id);
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du client : " + e.getMessage());
        }

        return client;
    }




}
