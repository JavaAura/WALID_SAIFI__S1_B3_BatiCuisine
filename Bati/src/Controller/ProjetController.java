package Controller;

import Metier.Client;
import Metier.EtatProjet;
import Metier.Projet;
import Service.ProjetService;

import java.util.List;


public class ProjetController {
    private  ProjetService projetService;
    private  ClientController clientController;

    public ProjetController(ProjetService projetService, ClientController clientController) {
        this.projetService = projetService;
        this.clientController = clientController;
    }

    public ProjetController() {
        this.projetService = new ProjetService();
        
    }

    public Projet creerProjet(Projet projet) {
        projetService.ajouterProjet(projet);
        return projet;
    }

    public List<Projet> obtenirTousLesProjets(){
        return projetService.obtenirTousLesProjets();
    }

    public  Projet obtenirProjetParNom(String nomProjet){

        return  projetService.obtenirProjetParNom(nomProjet);
    }




   



 }







