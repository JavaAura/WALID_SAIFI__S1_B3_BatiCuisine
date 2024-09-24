import Controller.ClientController;
import Metier.Client;
import Metier.Projet;
import Repository.ClientRepository;
import Repository.ProjetRepository;
import Service.ClientService;

public class Main {

    public static void main(String[] args) {


        ClientRepository clientRepo = new ClientRepository();


        Client client = clientRepo.getClientById(4);

        System.out.println(client.getId());


    }


    }


