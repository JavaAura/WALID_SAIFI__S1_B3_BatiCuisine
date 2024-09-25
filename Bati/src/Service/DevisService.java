package Service;

import Metier.Devis;
import Repository.DevisRepository;

public class DevisService implements IDevisService{
    public DevisRepository devisRepository;

    public DevisService(DevisRepository devisRepository) {
        this.devisRepository = devisRepository;
    }


    @Override
    public void ajouterDevis(Devis devis) {
        devisRepository.ajouterDevis(devis);
    }
}
