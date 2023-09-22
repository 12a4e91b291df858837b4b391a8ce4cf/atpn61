package data;

import utils.Constantes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionsBDDImpl implements ActionsBDD {
    private static ArrayList<Developpeur> listeDeveloppeurs = new ArrayList<>();
    private static Connection conn;

    /**
     * Ouvre une connexion à la base de données.
     * @throws SQLException Si une exception SQL est levée.
     */
    @Override
    public void openConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/APTN61_BD";
        String user = "root";
        String password = "root";
        conn = DriverManager.getConnection(url, user, password);
    }

    @Override
    public void createProgrammers() throws SQLException {
        Statement stmt = conn.createStatement();
        int rowsAffected = stmt.executeUpdate(Constantes.requeteInsertionJeuDeDonnee); // Utilisez executeUpdate() ici
        System.out.println(rowsAffected + " lignes insérées.");
    }

    /**
     * Récupère tous les programmeurs.sql à partir de la DB, puis les stocke dans l'ArrayList "ListeProgrammeurs".
     * @throws SQLException Si une exception SQL est levée.
     */
    @Override
    public void getProgrammers() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(Constantes.requeteDeSelectionDesProgrammeurs);
        while (rs.next()) {
            int id = rs.getInt("ID");
            String nom = rs.getString("NOM");
            String prenom = rs.getString("PRENOM");
            String adresse = rs.getString("ADRESSE");
            String responsable = rs.getString("RESPONSABLE");
            String hobby = rs.getString("HOBBY");
            int anNaissance = rs.getInt("ANAISSANCE");
            float salaire = rs.getFloat("SALAIRE");
            float prime = rs.getFloat("PRIME");

            Developpeur dev = new Developpeur(id, nom, prenom, adresse, responsable, hobby, anNaissance, salaire, prime);
            listeDeveloppeurs.add(dev);
        }
        System.out.println(listeDeveloppeurs);
    }
}