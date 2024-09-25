package Metier;

public class Materiel extends Composant {

    private double coutUnitaire;
    private double quantite;
    private double coutTransport;
    private double coefficientQualite;


    public Materiel(int id, String nom, double tauxTVA, double coutUnitaire, double quantite, double coutTransport, double coefficientQualite,Projet projet) {
        super(id, nom, "Materiel", tauxTVA, projet);
        this.coutUnitaire = coutUnitaire;
        this.quantite = quantite;
        this.coutTransport = coutTransport;
        this.coefficientQualite = coefficientQualite;
    
    }
    public Materiel( String nom, double tauxTVA, double coutUnitaire, double quantite, double coutTransport, double coefficientQualite) {
        super( nom, "Materiel", tauxTVA, null);
        this.coutUnitaire = coutUnitaire;
        this.quantite = quantite;
        this.coutTransport = coutTransport;
        this.coefficientQualite = coefficientQualite;
        
    
    }

    public double getCoutUnitaire() {
        return coutUnitaire;
    }

    public void setCoutUnitaire(double coutUnitaire) {
        this.coutUnitaire = coutUnitaire;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
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

    public double calculerCoutTotal() {
        double coutTotal = (((coutUnitaire * quantite * coefficientQualite)+coutTransport) * (1 + getTauxTVA())) ;
        return coutTotal;
    }


    @Override
    public String toString() {
        return "Materiel:" +
                "\nid=" + getId() +
                "\nnom='" + getNom() + '\'' +
                "\ncoutUnitaire=" + coutUnitaire +
                "\nquantite=" + quantite +
                "\ncoutTransport=" + coutTransport +
                "\ncoefficientQualite=" + coefficientQualite +
                "\ntauxTVA=" + getTauxTVA() +
                "\ncoutTotal=" + calculerCoutTotal() +
                "\nprojet=" + (getProjet() != null ? getProjet().toString() : "Aucun projet associé") +
                "\n";
    }








}
