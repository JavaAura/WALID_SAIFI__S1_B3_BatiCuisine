package Repository;

import Metier.Projet;

import java.util.List;

public interface IProjetRepository {


    Projet ajouterProjet(Projet projet);


    List<Projet> obtenirTousLesProjets();


    Projet obtenirProjetParId(Long id);


    Projet obtenirProjetParNom(String nom);

}
