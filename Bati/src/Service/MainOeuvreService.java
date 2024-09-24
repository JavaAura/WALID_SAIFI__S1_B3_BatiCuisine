package Service;

import Metier.MainOeuvre;
import Repository.MainOeuvreRepository;

import java.util.List;

public class MainOeuvreService implements  IMainOeuvreService {
    private  final MainOeuvreRepository mainOeuvreRepository;

    public MainOeuvreService(MainOeuvreRepository mainOeuvreRepository) {
        this.mainOeuvreRepository = mainOeuvreRepository;
    }


    @Override
    public void ajouterMainOeuvre(MainOeuvre mainOeuvre) {
        mainOeuvreRepository.ajouterMainOeuvre(mainOeuvre);
    }

    @Override
    public List<MainOeuvre> getAllComposantsByProject(Long projectId) {
        return  mainOeuvreRepository.getAllComposantsByProject(projectId);
    }
}
