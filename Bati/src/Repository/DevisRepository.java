package Repository;

import Metier.Devis;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class DevisRepository implements IDevisRepository {


    @Override
    public void ajouterDevis(Devis devis) {
        String sql = "INSERT INTO Devis (montantEstime, dateEmission, dateValidite, accepte, projetId) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, devis.getMontantEstime());
            stmt.setDate(2, Date.valueOf(devis.getDateEmission()));
            stmt.setDate(3, Date.valueOf(devis.getDateValidite()));
            stmt.setBoolean(4, devis.isAccepte());
            stmt.setLong(5, devis.getProjet().getId());

            stmt.executeUpdate();
            System.out.println("Devis ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du devis : " + e.getMessage());
        }
    }

    @Override
    public void mettreAJourAccordDevis(Devis devis) {

    }

    @Override
    public Devis obtenirDevisParId(int id) {

        return null;
    }

    @Override
    public Devis trouverParProjetId(Long projetId) {

        return null;
    }
}
