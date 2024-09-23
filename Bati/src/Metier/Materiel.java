package Metier;

public class Materiel extends Composant {

    private double coutUnitaire;
    private double quantite;
    private double coutTransport;
    private double coefficientQualite;

    public Materiel() {

    }

    public double getCoutTransport() {
        return coutTransport;
    }

    public void setCoutTransport(double coutTransport) {
        this.coutTransport = coutTransport;
    }

    public double getCoefficientQualite() {
        return coefficientQualite;
    }

    public void setCoefficientQualite(double coefficientQualite) {
        this.coefficientQualite = coefficientQualite;
    }

    public Materiel(String nom, double coutUnitaire, double quantite, String typeComposant, double tauxTVA) {
        super(nom, coutUnitaire, quantite, typeComposant, tauxTVA);
    }
    @Override
    public double getCoutUnitaire() {
        return coutUnitaire;
    }

    @Override
    public void setCoutUnitaire(double coutUnitaire) {
        this.coutUnitaire = coutUnitaire;
    }

    @Override
    public double getQuantite() {
        return quantite;
    }

    @Override
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }


}
