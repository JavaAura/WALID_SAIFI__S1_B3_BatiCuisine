package Metier;

import java.util.Date;

public class Devis {

    private int id;
    private double montantEstime;
    private Date dateEmission;
    private Date dateValidite;
    private boolean accepte;

    public Devis(int id, double margeBeneficiaire, Projet projet, Date dateValidite, Date dateEmission, double montantEstime, boolean accepte, double tva) {
        this.id = id;
        this.margeBeneficiaire = margeBeneficiaire;
        this.projet = projet;
        this.dateValidite = dateValidite;
        this.dateEmission = dateEmission;
        this.montantEstime = montantEstime;
        this.accepte = accepte;
        this.tva = tva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMargeBeneficiaire() {
        return margeBeneficiaire;
    }

    public void setMargeBeneficiaire(double margeBeneficiaire) {
        this.margeBeneficiaire = margeBeneficiaire;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public boolean isAccepte() {
        return accepte;
    }

    public void setAccepte(boolean accepte) {
        this.accepte = accepte;
    }

    public Date getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(Date dateValidite) {
        this.dateValidite = dateValidite;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public double getMontantEstime() {
        return montantEstime;
    }

    public void setMontantEstime(double montantEstime) {
        this.montantEstime = montantEstime;
    }

    private Projet projet;
    private double tva;
    private double margeBeneficiaire;
}
