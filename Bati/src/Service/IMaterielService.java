package Service;

import Metier.Materiel;

import java.util.List;

public interface IMaterielService {
    void ajouterMateriel(Materiel materiel);
    List<Materiel> getAllMaterielsByProject(Long projectId);
}
