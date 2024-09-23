package Repository;

import Metier.Materiel;

import java.util.List;

public interface IMaterielRepository {
    void ajouterMateriel(Materiel materiel, int id);
    public List<Materiel> getAllMaterieByProject(Long projectId);
}
