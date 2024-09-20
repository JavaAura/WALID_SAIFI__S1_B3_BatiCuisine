package Metier;

import java.util.List;

public class Projet{
    private String nomProjet;
    private double margeBeneficiaire;
    private double coutTotal;
    private String etatProjet;
    private Client client;
    private List<Composant> composants;

    public Projet(String nomProjet, List<Composant> composants, Client client, double coutTotal, double margeBeneficiaire) {
        this.nomProjet = nomProjet;
        this.composants = composants;
        this.client = client;
        this.etatProjet = "EN_COURS";
        this.coutTotal = coutTotal;
        this.margeBeneficiaire = margeBeneficiaire;
    }


}
