package Repository;

import Metier.Composant;

import java.util.List;

public interface IComposantRepository   {


    void ajouterComposant(Composant composant);

    List<Composant> obtenirTousLesComposantsParProjet(Long projetId);

}
