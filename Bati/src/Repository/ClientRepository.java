package Repository;

import Metier.Client;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
