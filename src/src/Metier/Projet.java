package Metier;

import java.util.List;

public class Projet {

    private String nomProjet;
    private double margeBeneficiaire;
    private double coutTotal;
    private String etatProjet;
    private Client client;
    private List<Composant> composants;

    public String getNomProjet() {
        return nomProjet;
    }


    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getEtatProjet() {
        return etatProjet;
    }

    public void setEtatProjet(String etatProjet) {
        this.etatProjet = etatProjet;
    }

    public double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public double getMargeBeneficiaire() {
        return margeBeneficiaire;
    }

    public void setMargeBeneficiaire(double margeBeneficiaire) {
        this.margeBeneficiaire = margeBeneficiaire;
    }

    public Projet(String nomProjet, double margeBeneficiaire, double coutTotal, Client client, List<Composant> composants) {
        this.nomProjet = nomProjet;
        this.margeBeneficiaire = margeBeneficiaire;
        this.coutTotal = coutTotal;
        this.etatProjet ="EN_COURS";
        this.client = client;
        this.composants = composants;
    }
}
