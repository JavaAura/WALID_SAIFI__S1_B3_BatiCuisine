package Repository;

import Metier.MainOeuvre;
import Metier.Materiel;

import java.util.List;

public class MaterielRepository implements  IMaterielRepository{

    @Override
    public void ajouterMateriel(Materiel materiel, int id) {

    }

    @Override
    public List<Materiel> getAllMaterieByProject(Long projectId) {
        return List.of();
    }
}
