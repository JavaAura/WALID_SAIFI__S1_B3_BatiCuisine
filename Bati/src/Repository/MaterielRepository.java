package Repository;

import Metier.MainOeuvre;
import Metier.Materiel;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterielRepository implements  IMaterielRepository{

    @Override
    public void ajouterMateriel(Materiel materiel) {
        String sql = "INSERT INTO Materiau (nom, coutUnitaire, quantite, typeComposant, tauxTVA, coutTransport, coefficientQualite, projetId) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, materiel.getNom());
            stmt.setDouble(2, materiel.getCoutUnitaire());
            stmt.setDouble(3, materiel.getQuantite());
            stmt.setString(4, materiel.getTypeComposant());
            stmt.setDouble(5, materiel.getTauxTVA());
            stmt.setDouble(6, materiel.getCoutTransport());
            stmt.setDouble(7, materiel.getCoefficientQualite());
            stmt.setLong(8,materiel.getProjet().getId());


            stmt.executeUpdate();
            System.out.println("Matériel ajouté avec succès.");

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du matériel : " + e.getMessage());
        }
    }


    @Override
    public List<Materiel> getAllMaterieByProject(Long projectId) {
        List<Materiel> materiaux = new ArrayList<>();
        String sql = "SELECT * FROM Materiau WHERE projetId = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, projectId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Materiel materiel = new Materiel();
                materiel.setNom(rs.getString("nom"));
                materiel.setCoutUnitaire(rs.getDouble("coutUnitaire"));
                materiel.setQuantite(rs.getDouble("quantite"));
                materiel.setTypeComposant(rs.getString("typeComposant"));
                materiel.setTauxTVA(rs.getDouble("tauxTVA"));
                materiel.setCoutTransport(rs.getDouble("coutTransport"));
                materiel.setCoefficientQualite(rs.getDouble("coefficientQualite"));

                materiaux.add(materiel);
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des matériaux par projet : " + e.getMessage());
        }

        return materiaux;
    }

}
