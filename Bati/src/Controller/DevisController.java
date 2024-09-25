package Controller;

import Metier.Devis;
import Service.DevisService;

public class DevisController {
    public DevisService devisService;

    public DevisController(DevisService devisService){
        this.devisService = devisService;
    }


    public void ajouterDevis(Devis devis) {
        devisService.ajouterDevis(devis);
    }

}
