package Service;

import Metier.Projet;
import Repository.ProjetRepository;

import java.util.List;

public class ProjetService implements  IProjetService{

    private   ProjetRepository projetRepository;

    public  ProjetService(){

        this.projetRepository = new ProjetRepository();
    }



    @Override
    public Projet ajouterProjet(Projet projet) {
        return projetRepository.ajouterProjet(projet);

    }

    @Override
    public List<Projet> obtenirTousLesProjets() {
        return  projetRepository.obtenirTousLesProjets();
    }

    @Override
    public Projet obtenirProjetParId(Long id) {
        return  projetRepository.obtenirProjetParId(id);
    }

    @Override
    public Projet obtenirProjetParNom(String nom) {
        return  projetRepository.obtenirProjetParNom(nom);
    }
}
