package Service;

import Metier.Projet;
import Repository.ProjetRepository;

import java.util.List;

public class ProjetService implements  IProjetService{

    private final  ProjetRepository projetRepository;

    public  ProjetService(ProjetRepository projetRepository){

        this.projetRepository = projetRepository;
    }



    @Override
    public void ajouterProjet(Projet projet) {
        projetRepository.ajouterProjet(projet);

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
