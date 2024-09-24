package Service;

import Metier.MainOeuvre;

import java.util.List;

public interface IMainOeuvreService {

    void ajouterMainOeuvre(MainOeuvre mainOeuvre);

    public List<MainOeuvre> getAllComposantsByProject(Long projectId);

}
