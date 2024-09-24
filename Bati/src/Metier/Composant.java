package Metier;

public class Composant {
        private  int id;
        private String nom;
        private double coutUnitaire;
        private double quantite;
        private String typeComposant;
        private double tauxTVA;
        private Projet projet;

    public Composant() {

    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Composant(String nom, double coutUnitaire, double quantite, String typeComposant, double tauxTVA) {
            this.nom = nom;
            this.coutUnitaire = coutUnitaire;
            this.quantite = quantite;
            this.typeComposant = typeComposant;
            this.tauxTVA = tauxTVA;
        }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getTypeComposant() {
        return typeComposant;
    }

    public void setTypeComposant(String typeComposant) {
        this.typeComposant = typeComposant;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }
}
