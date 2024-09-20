package Metier;

public class Client {
    private String nom;
    private  String adresse;
    private  String telephone;
    private boolean estProfessionnel;

    public Client(String adresse, String nom, String telephone, boolean estProfessionnel) {
        this.adresse = adresse;
        this.nom = nom;
        this.telephone = telephone;
        this.estProfessionnel = estProfessionnel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isEstProfessionnel() {
        return estProfessionnel;
    }

    public void setEstProfessionnel(boolean estProfessionnel) {
        this.estProfessionnel = estProfessionnel;
    }
}
