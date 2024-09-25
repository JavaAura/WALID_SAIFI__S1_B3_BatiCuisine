package Metier;

public  class MainOeuvre extends Composant {
    private double tauxHoraire;
    private double heuresTravail;
    private double productiviteOuvrier;

    public MainOeuvre(int id, String nom, double tauxHoraire, double heuresTravail, double productiviteOuvrier, double tauxTVA, Projet projet) {
        super(id, nom, "MainOeuvre", tauxTVA, projet);
       
        this.tauxHoraire = tauxHoraire;
        this.heuresTravail = heuresTravail;
        this.productiviteOuvrier = productiviteOuvrier;
    }
    public MainOeuvre(String nom, double tauxHoraire, double heuresTravail, double productiviteOuvrier,  double tauxTVA) {
        super(nom, "MainOeuvre", tauxTVA, null);
        this.tauxHoraire = tauxHoraire;
        this.heuresTravail = heuresTravail;
        this.productiviteOuvrier = productiviteOuvrier;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }
    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
    public double getHeuresTravail() {
        return heuresTravail;
    }           
    public double getProductiviteOuvrier() {
        return productiviteOuvrier;
    }
    public void setProductiviteOuvrier(double productiviteOuvrier) {
        this.productiviteOuvrier = productiviteOuvrier;
    }

    public double calculerCoutTotal() {
       return (tauxHoraire * heuresTravail * productiviteOuvrier)*(1+getTauxTVA());
    };

    public void setHeuresTravail(double heuresTravail) {
    }

    @Override
    public String toString() {
        return "MainOeuvre : " +
                "\nid=" + getId() +
                "\nnom='" + getNom() + '\'' +
                "\ntauxHoraire=" + tauxHoraire +
                "\nheuresTravail=" + heuresTravail +
                "\nproductiviteOuvrier=" + productiviteOuvrier +
                "\ntauxTVA=" + getTauxTVA() +
                "\ncoutTotal=" + calculerCoutTotal() +
                "\nprojet=" + (getProjet() != null ? getProjet().toString() : "Aucun projet associé") +
                "\n";
    }



}
