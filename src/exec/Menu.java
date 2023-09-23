package exec;
import data.ActionsBDDImpl;
import data.Developpeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Constantes;

public class Menu extends ActionsBDDImpl {
    private Scanner sc = new Scanner(System.in);

    private void dbConnectionAndInitialization() throws SQLException {
        super.openConnection();
        super.createProgrammers();
    }
    public void printMenu() throws SQLException {
        dbConnectionAndInitialization();

        int choice;
        boolean validInput;

        do {
            System.out.println("<<<<<<<<<<   MENU   >>>>>>>>>>" + "\n\n" +
                    "1. Afficher tous les programmeurs" + "\n\n" +
                    "2. Afficher un programmeur" + "\n\n" +
                    "3. Supprimer un programmeur" + "\n\n" +
                    "4. Ajouter un programmeur" + "\n\n" +
                    "5. Modifier le salaire" + "\n\n" +
                    "6. Quitter le programme" + "\n\n" +
                    "Quel est votre choix ? : ");

            choice = sc.nextInt();
            validInput = true;  // On suppose que l'entrée est valide au départ

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
                default:
                    System.out.println("ERREUR! Veuillez saisir un nombre entre 1 et 6");
                    validInput = false;
                    break;
            }
        } while(!validInput);

    }

    private void choiceOne() throws SQLException {
        super.getProgrammers();
    }

    private void choiceTwo(int choice) throws SQLException {
        super.getProgrammerById(choice);
    }

    private void choiceSix() {
        System.exit(0);
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
