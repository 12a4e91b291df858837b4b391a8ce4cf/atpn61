package exec;
import data.ActionsBDDImpl;
import data.Developpeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import utils.Constantes;

public class Menu extends ActionsBDDImpl {
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
