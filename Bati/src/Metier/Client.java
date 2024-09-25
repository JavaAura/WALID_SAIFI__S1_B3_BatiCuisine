package Metier;

public class Client {
    private  long id;
    private String nom;
    private String adresse;
    private String telephone;
    private boolean estProfessionnel;

    public Client(long id , String adresse, String nom, String telephone, boolean estProfessionnel) {
        this.id = id;
        this.adresse = adresse;
        this.nom = nom;
        this.telephone = telephone;
        this.estProfessionnel = estProfessionnel;
    }

    public Client( String adresse, String nom, String telephone, boolean estProfessionnel) {
        this.adresse = adresse;
        this.nom = nom;
        this.telephone = telephone;
        this.estProfessionnel = estProfessionnel;
    }
    public Client(){

    }

    public void setId(long id) {
        this.id = id;
    }       

    public long getId(){
        return  this.id;
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isEstProfessionnel() {
        return this.estProfessionnel;
    }

    public void setEstProfessionnel(boolean estProfessionnel) {
        this.estProfessionnel = estProfessionnel;
    }


    @Override
    public String toString() {
        return "Client\n" +
                "id=" + id +
                "\nnom='" + nom + '\'' +
                "\nadresse='" + adresse + '\'' +
                "\ntelephone='" + telephone + '\'' +
                "\nestProfessionnel=" + estProfessionnel;
    }


}
