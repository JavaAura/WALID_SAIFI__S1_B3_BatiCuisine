package Presentation;
import  java.util.*;

public class ConsoleUI {


    public void afficherMenu() {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("Menu:");
            System.out.println("1. Créer un nouveau projet");
            System.out.println("2. Afficher les projets existants");
            System.out.println("3. Calculer le coût d'un projet");
            System.out.println("4. Quitter");
            System.out.print("Veuillez choisir une option (1-4): ");

            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    // Appel à la méthode pour créer un nouveau projet
                   // creerNouveauProjet(scanner);
                    break;
                case 2:
                    // Appel à la méthode pour afficher les projets existants
                   // afficherProjetsExistants();
                    break;
                case 3:
                    // Appel à la méthode pour calculer le coût d'un projet
                   // calculerCoutProjet(scanner);
                    break;
                case 4:
                    System.out.println("Merci d'avoir utilisé l'application. À bientôt!");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 4);

        scanner.close();
    }




    







}
