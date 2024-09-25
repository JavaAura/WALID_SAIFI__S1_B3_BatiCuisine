package Controller;

import Metier.Materiel;
import Service.MaterielService;

import java.util.List;

public class MaterielController {

    
    private MaterielService service;


    public MaterielController(MaterielService service) {
        this.service = service;
    }

    public void ajouterListeMateriaux(List<Materiel> materiaux) {
        for (Materiel materiel : materiaux) {
            service.ajouterMateriel(materiel);
        }
    }
}
