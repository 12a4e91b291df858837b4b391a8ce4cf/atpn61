package exec;
import data.ActionsBDDImpl;

import java.sql.*;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private ActionsBDDImpl actionsBDD = new ActionsBDDImpl();

    public void dbConnectionAndInitialization() throws SQLException {
        actionsBDD.openConnection();
        actionsBDD.flushDb();
        actionsBDD.createProgrammers();
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
        Scanner sc = new Scanner(System.in);
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
                System.out.print("Nom du programmeur : ");
                String nom = sc.nextLine();
                System.out.print("Prénom du programmeur : ");
                String prenom = sc.nextLine();
                System.out.print("Adresse du programmeur : ");
                String adresse = sc.nextLine();
                System.out.print("Pseudo du programmeur : ");
                String pseudo = sc.nextLine();
                System.out.print("Responsable du programmeur : ");
                String responsable = sc.nextLine();
                System.out.print("Hobby du programmeur : ");
                String hobby = sc.nextLine();
                System.out.print("Année de naissance du programmeur : ");
                int anNaissance = sc.nextInt();
                System.out.print("Salaire du programmeur : ");
                int salaire = sc.nextInt();
                System.out.print("Prime du programmeur : ");
                int prime = sc.nextInt();
                choiceFour(nom, prenom,adresse, pseudo, responsable, hobby, anNaissance, salaire, prime);
                break;
            case 5:
                System.out.println("Id du programmeur");
                int idToModify = sc.nextInt();
                choiceFive(idToModify);
                break;
            case 6:
                choiceSix();
        }
    }
    private void choiceOne() throws SQLException {
        actionsBDD.getProgrammers();
        askToReturnToMainMenu();
    }

    private void choiceTwo(int choice) throws SQLException {
        boolean continueAskingValidId = true;

        while(continueAskingValidId) {
            if(actionsBDD.getProgrammerById(choice)) {
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
            if(actionsBDD.deleteProgrammerById(choice)) {
                continueAskingValidId = false;
            } else {
                System.out.println("Suppression KO. Saisissez à nouveau l'id :");
                choice = sc.nextInt();
            }
        }

        askToReturnToMainMenu();
    }

    private void choiceFour(String nom,String prenom, String adresse, String pseudo,
                            String responsable, String hobby, int anNaissance,
                            int salaire, int prime) throws SQLException {


        actionsBDD.addProgrammers(nom, prenom,adresse, pseudo, responsable, hobby, anNaissance, salaire, prime);

        askToReturnToMainMenu();
    }

    private void choiceFive(int id) throws SQLException{
        boolean continueAskingValidId = true;

        while(continueAskingValidId) {
            if(actionsBDD.doesProgrammeurExist(id)) {
                continueAskingValidId = false;
            } else {
                System.out.println("Programmeur introuvable. Saisissez à nouveau l'id :");
                id = sc.nextInt();
            }
        }
        System.out.println("Nouveau salaire de ce programmeur :");
        float Salaire = sc.nextInt();
        actionsBDD.modifySalaryById(id, Salaire);

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
