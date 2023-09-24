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
                int idChoice = sc.nextInt();
                choiceTwo(idChoice);
                break;
            case 3:
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
        if (returnToMainMenu())
            printMenu();
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

        if (returnToMainMenu())
            printMenu();
    }

    private void choiceSix() {
        System.exit(0);
    }

    private boolean returnToMainMenu() {
        System.out.println("Appuyez sur 7 pour revenir au menu principal ou sur n'importe quelle autre touche pour continuer.");
        int input = sc.nextInt();
        return input == 7;
    }

    /*
    private static ArrayList<Developpeur> listeDeveloppeurs = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static Connection conn;

    /**
     * Ouvre une connexion à la base de données.
     * @throws SQLException Si une exception SQL est levée.
     */

    /*
    public static void openConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/APTN61_BD";
        String user = "root";
        String password = "root";
        conn = DriverManager.getConnection(url, user, password);
    }
    /**
     * Récupère tous les programmeurs.sql à partir de la DB, puis les stocke dans l'ArrayList "ListeProgrammeurs".
     * @throws SQLException Si une exception SQL est levée.
     */

    /*
    public static void getProgrammers() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(Constantes.requeteDeSelectionDesProgrammeurs);
        while (rs.next()) {
            int id = rs.getInt("ID");
            String nom = rs.getString("NOM");
            String prenom = rs.getString("PRENOM");
            String adresse = rs.getString("ADRESSE"); // Assurez-vous que ce champ existe dans votre table SQL
            String hobby = rs.getString("HOBBY"); // Assurez-vous que ce champ existe dans votre table SQL
            int anNaissance = rs.getInt("ANNAISSANCE");
            float salaire = rs.getFloat("SALAIRE");
            float prime = rs.getFloat("PRIME");

            Developpeur dev = new Developpeur(id, nom, prenom, adresse, hobby, anNaissance, salaire, prime);
            listeDeveloppeurs.add(dev);
        }
    }
     */

}
