package Repository;

import Metier.MainOeuvre;

import java.util.List;

public interface IMainOeuvreRepository {
    void ajouterMainOeuvre(MainOeuvre mainOeuvre);
    public List<MainOeuvre> getAllComposantsByProject(Long projectId);
}
