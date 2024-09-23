import Service.ClientService;

public class Main {

    public static void main(String[] args) {

        ClientService clt = new ClientService();
        clt.ajouterClient("John Doe", "456 Rue de la Paix", "0987654321", false);

    }

}