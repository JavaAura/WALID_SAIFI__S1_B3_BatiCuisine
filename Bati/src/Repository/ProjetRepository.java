package Repository;

import Metier.Projet;
import Metier.EtatProjet; // Import de l'énumération
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetRepository implements IProjetRepository {

    @Override
    public void ajouterProjet(Projet projet) {
        String sql = "INSERT INTO Projet (nomProjet, margeBeneficiaire, coutTotal, etatProjet, clientid) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, projet.getNomProjet());
            stmt.setDouble(2, projet.getMargeBeneficiaire());
            stmt.setDouble(3, projet.getCoutTotal());
            stmt.setString(4, projet.getEtatProjet().name());
            stmt.setLong(5, projet.getClient().getId());

            stmt.executeUpdate();
            System.out.println("Projet ajouté avec succès !");

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du projet : " + e.getMessage());
        }
    }

    @Override
    public List<Projet> obtenirTousLesProjets() {
        List<Projet> projets = new ArrayList<>();
        String sql = "SELECT * FROM Projet";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Projet projet = new Projet();
                projet.setId(rs.getLong("id"));
                projet.setNomProjet(rs.getString("nomProjet"));
                projet.setMargeBeneficiaire(rs.getDouble("margeBeneficiaire"));
                projet.setCoutTotal(rs.getDouble("coutTotal"));
                projet.setEtatProjet(EtatProjet.valueOf(rs.getString("etatProjet")));

                projets.add(projet);
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des projets : " + e.getMessage());
        }

        return projets;
    }

    @Override
    public Projet obtenirProjetParId(Long id) {
        Projet projet = null;
        String sql = "SELECT * FROM Projet WHERE id = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    projet = new Projet();
                    projet.setId(rs.getLong("id"));
                    projet.setNomProjet(rs.getString("nomProjet"));
                    projet.setMargeBeneficiaire(rs.getDouble("margeBeneficiaire"));
                    projet.setCoutTotal(rs.getDouble("coutTotal"));
                    projet.setEtatProjet(EtatProjet.valueOf(rs.getString("etatProjet")));

                }
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du projet : " + e.getMessage());
        }

        return projet;
    }

    @Override
    public Projet obtenirProjetParNom(String nom) {
        Projet projet = null;
        String sql = "SELECT * FROM Projet WHERE nomProjet = ?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    projet = new Projet();
                    projet.setId(rs.getLong("id"));
                    projet.setNomProjet(rs.getString("nomProjet"));
                    projet.setMargeBeneficiaire(rs.getDouble("margeBeneficiaire"));
                    projet.setCoutTotal(rs.getDouble("coutTotal"));
                    projet.setEtatProjet(EtatProjet.valueOf(rs.getString("etatProjet")));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération du projet : " + e.getMessage());
        }

        return projet;
    }
}
