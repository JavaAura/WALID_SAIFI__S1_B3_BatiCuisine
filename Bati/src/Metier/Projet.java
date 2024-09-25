package Metier;


public class Projet {
    private long id;
    private String nomProjet;
    private double surface;
    private double margeBeneficiaire;
    private double coutTotal;
    private EtatProjet etatProjet;
    private Client client;

    public Projet (long id, String nomProjet,Double surface,Client client, double coutTotal, double margeBeneficiaire, EtatProjet etatProjet) {
        this.id = id;
        this.nomProjet = nomProjet;
        this.surface = surface;
        this.client = client;
        this.coutTotal = coutTotal;
        this.margeBeneficiaire = margeBeneficiaire;
        this.etatProjet = etatProjet;
    }

    public Projet(String nomProjet,Double surface,Client client, double coutTotal, double margeBeneficiaire) {
        this.nomProjet = nomProjet;
        this.surface = surface;
        this.client = client;
        this.coutTotal = coutTotal;
        this.margeBeneficiaire = margeBeneficiaire;
        this.etatProjet = EtatProjet.EN_COURS;
    }
    public Projet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public EtatProjet getEtatProjet() {
        return etatProjet;
    }

    public void setEtatProjet(EtatProjet etatProjet) {
        this.etatProjet = etatProjet;
    }

    public void setNom(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    @Override
    public String toString() {
        return "Projet :" +
                "\nid=" + id +
                "\nnomProjet='" + nomProjet + '\'' +
                "\nsurface=" + surface +
                "\ncoutTotal=" + coutTotal +
                "\nmargeBeneficiaire=" + margeBeneficiaire +
                "\netatProjet=" + etatProjet +
                "\nclient de ce projet: " + (client != null ? client.toString() : "Aucun client");
    }

}
