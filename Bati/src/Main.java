import Controller.ClientController;
import Metier.Client;
import Metier.Projet;
import Presentation.ConsoleUI;
import Repository.ClientRepository;
import Repository.ProjetRepository;
import Service.ClientService;
import Service.ProjetService;

public class Main {

    public static void main(String[] args) {

      

        ClientService clientService = new ClientService();
        ProjetService projetS1ervice = new ProjetService();


        ClientController clientController = new ClientController();


        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.afficherMenu();
    }
}




