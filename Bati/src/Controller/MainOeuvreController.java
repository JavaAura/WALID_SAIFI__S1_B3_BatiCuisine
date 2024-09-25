package Controller;

import Metier.MainOeuvre;
import Service.MainOeuvreService;

import java.util.List;

public class MainOeuvreController {


    private MainOeuvreService service;


    public MainOeuvreController(MainOeuvreService service) {
        this.service = service;
    }

    public void ajouterListeMainOeuvre(List<MainOeuvre> mainOeuvreList) {
        for (MainOeuvre mainOeuvre : mainOeuvreList) {
            service.ajouterMainOeuvre(mainOeuvre);
        }
    }
}
