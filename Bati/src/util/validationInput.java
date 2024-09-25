package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class validationInput {

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate validationDate(Scanner scanner) {
        LocalDate date = null;

        while (date == null) {
            System.out.print("Veuillez saisir une date (JJ/MM/AAAA) : ");
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input, DATE_FORMAT);
            } catch (DateTimeParseException e) {
                System.out.println("Format de date invalide. Veuillez réessayer.");
            }
        }
        return date;
    }

    public static double validationDouble(Scanner scanner) {
        double number = 0.0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Entrez un nombre décimal (double) : ");
            try {
                number = scanner.nextDouble();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Erreur: entrez un nombre décimal valide !");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.nextLine(); // Consume the newline character
        return number;
    }

    public static String validationChaine(Scanner scanner) {
        String input = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Entrez une chaîne de caractères non vide : ");
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                isValid = true;
            } else {
                System.out.println("Erreur : La chaîne ne peut pas être vide. Veuillez réessayer.");
            }
        }
        return input;
    }
}
