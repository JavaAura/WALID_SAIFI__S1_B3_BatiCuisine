package Metier;

public class MainOeuvre extends Composant{

    private double tauxHoraire;
    private double heuresTravail;
    private double productiviteOuvrier;


    public MainOeuvre(String nom, double coutUnitaire, double quantite, String typeComposant, double tauxTVA) {
        super(nom, coutUnitaire, quantite, typeComposant, tauxTVA);
    }

    public MainOeuvre() {
        super();
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public double getProductiviteOuvrier() {
        return productiviteOuvrier;
    }

    public void setProductiviteOuvrier(double productiviteOuvrier) {
        this.productiviteOuvrier = productiviteOuvrier;
    }

    public double getHeuresTravail() {
        return heuresTravail;
    }

    public void setHeuresTravail(double heuresTravail) {
        this.heuresTravail = heuresTravail;
    }
}
