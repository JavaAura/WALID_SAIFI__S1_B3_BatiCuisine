package Service;

import java.util.List;
import Metier.Materiel;
import Repository.MaterielRepository;

public class MaterielService implements IMaterielService {
    private final MaterielRepository materielRepository;

    public MaterielService(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    @Override
    public void ajouterMateriel(Materiel materiel) {

        materielRepository.ajouterMateriel(materiel);
    }

    @Override
    public List<Materiel> getAllMaterielsByProject(Long projectId) {

        return materielRepository.getAllMaterieByProject(projectId);
    }
}
