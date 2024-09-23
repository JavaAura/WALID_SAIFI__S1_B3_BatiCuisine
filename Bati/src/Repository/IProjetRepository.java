package Repository;

import Metier.Projet;

import java.util.List;

public interface IProjetRepository {


    void ajouterProjet(Projet projet);


    List<Projet> obtenirTousLesProjets();


    Projet obtenirProjetParId(Long id);


    Projet obtenirProjetParNom(String nom);

}
