package exec;
import data.ActionsBDDImpl;

import java.sql.*;
import java.util.Scanner;

public class Menu extends ActionsBDDImpl {
    private Scanner sc = new Scanner(System.in);

    public void dbConnectionAndInitialization() throws SQLException {
        super.openConnection();
        super.flushDb();
        super.createProgrammers();
    }
    public void printMenu() throws SQLException {
        int choice;

        while(true) {
            displayMenu();
            choice = sc.nextInt();

            while (choice < 1 || choice > 6) {
                System.out.println("ERREUR! Veuillez saisir un nombre entre 1 et 6");
                choice = sc.nextInt();
            }

            makeAChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("<<<<<<<<<<   MENU   >>>>>>>>>>" + "\n\n" +
                "1. Afficher tous les programmeurs" + "\n\n" +
                "2. Afficher un programmeur" + "\n\n" +
                "3. Supprimer un programmeur" + "\n\n" +
                "4. Ajouter un programmeur" + "\n\n" +
                "5. Modifier le salaire" + "\n\n" +
                "6. Quitter le programme" + "\n\n" +
                "7. Cette touche est réservée pour retourner sur le menu principal" + "\n\n" +
                "Quel est votre choix ? : ");
    }

    private void makeAChoice(int choice) throws SQLException {
        switch(choice) {
            case 1:
                choiceOne();
                break;
            case 2:
                System.out.println("Id du programmeur à afficher");
                int idChoiceAdd = sc.nextInt();
                choiceTwo(idChoiceAdd);
                break;
            case 3:
                System.out.println("Id du programmeur à supprimer");
                int idChoiceDelete = sc.nextInt();
                choiceThree(idChoiceDelete);
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                choiceSix();
        }
    }
    private void choiceOne() throws SQLException {
        super.getProgrammers();
        askToReturnToMainMenu();
    }

    private void choiceTwo(int choice) throws SQLException {
        boolean continueAskingValidId = true;

        while(continueAskingValidId) {
            if(super.getProgrammerById(choice)) {
                continueAskingValidId = false;
            } else {
                System.out.println("Recherche KO. Saisissez a nouveau l'id : ");
                choice = sc.nextInt();
            }
        }

        askToReturnToMainMenu();
    }

    private void choiceThree(int choice) throws SQLException {
        boolean continueAskingValidId = true;

        while(continueAskingValidId) {
            if(super.deleteProgrammerById(choice)) {
                continueAskingValidId = false;
            } else {
                System.out.println("Suppression KO. Saisissez à nouveau l'id :");
                choice = sc.nextInt();
            }
        }

        askToReturnToMainMenu();
    }

    private void choiceSix() {
        System.exit(0);
    }

    private boolean returnToMainMenu() {
        System.out.println("Appuyez sur 7 pour revenir au menu principal ou sur n'importe quelle autre touche pour " +
                "quitter le programme.");
        int input = sc.nextInt();
        return input == 7;
    }

    private void askToReturnToMainMenu() throws SQLException {
        if (returnToMainMenu()) {
            printMenu();
        } else {
            System.exit(0);
        }
    }

}
