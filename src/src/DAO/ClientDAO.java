package DAO;

import Metier.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAO {


    public void ajouterClient(Client client) {
        Connection connection = null;
        PreparedStatement statement = null;

        String sql = "INSERT INTO Client(nom, adresse, telephone, estProfessionnel) VALUES (?, ?, ?, ?)";

        try {

            connection = DBConnection.getConnection();


            statement = connection.prepareStatement(sql);
            statement.setString(1, client.getNom());
            statement.setString(2, client.getAdresse());
            statement.setString(3, client.getTelephone());
            statement.setBoolean(4, client.isEstProfessionnel());


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Un nouveau client a été ajouté avec succès !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBConnection.closeConnection(connection);
        }
    }
}
