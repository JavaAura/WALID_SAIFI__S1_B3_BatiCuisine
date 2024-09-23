package Repository;

import Metier.Devis;

public interface IDevisRepository {

    void ajouterDevis(Devis devis);

    void mettreAJourAccordDevis(Devis devis);

    Devis obtenirDevisParId(int id);

    Devis trouverParProjetId(Long projetId);


}
