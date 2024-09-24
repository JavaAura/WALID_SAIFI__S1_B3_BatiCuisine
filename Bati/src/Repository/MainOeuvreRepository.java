package Repository;

import Metier.MainOeuvre;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainOeuvreRepository implements  IMainOeuvreRepository{


    @Override
    public void ajouterMainOeuvre(MainOeuvre mainOeuvre) {
        String sql = "INSERT INTO MainOeuvre (nom, tauxHoraire, heuresTravail, productiviteOuvrier, tauxTVA, projetId) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, mainOeuvre.getNom());
            stmt.setDouble(2, mainOeuvre.getTauxHoraire());
            stmt.setDouble(3, mainOeuvre.getHeuresTravail());
            stmt.setDouble(4, mainOeuvre.getProductiviteOuvrier());
            stmt.setDouble(5, mainOeuvre.getTauxTVA());
            stmt.setInt(6, mainOeuvre.getProjet().getId());



            stmt.executeUpdate();
            System.out.println("Main d'oeuvre ajoutée avec succès.");

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de la main d'oeuvre : " + e.getMessage());
        }
    }


    @Override
    public List<MainOeuvre> getAllComposantsByProject(Long projectId) {
        List<MainOeuvre> mainOeuvres = new ArrayList<>();
        String sql = "SELECT * FROM MainOeuvre WHERE projetId = ?";
        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, projectId);


            ResultSet rs = stmt.executeQuery();


            while (rs.next()) {
                MainOeuvre mainOeuvre = new MainOeuvre();
                mainOeuvre.setNom(rs.getString("nom"));
                mainOeuvre.setTauxHoraire(rs.getDouble("tauxHoraire"));
                mainOeuvre.setHeuresTravail(rs.getDouble("heuresTravail"));
                mainOeuvre.setProductiviteOuvrier(rs.getDouble("productiviteOuvrier"));
                mainOeuvre.setTauxTVA(rs.getDouble("tauxTVA"));
                mainOeuvres.add(mainOeuvre);
            }

        } catch (SQLException e) {
            System.err.println("SQL error while retrieving MainOeuvre by project: " + e.getMessage());
            e.printStackTrace();
        }

        return mainOeuvres;
    }


}
