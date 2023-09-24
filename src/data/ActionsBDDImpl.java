package data;

import utils.Constantes;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
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

    /**
     * Récupère tous les programmeurs.sql à partir de la DB, puis les stocke dans l'ArrayList "ListeProgrammeurs".
     * @throws SQLException Si une exception SQL est levée.
     */
    @Override
    public void createProgrammers() throws SQLException {
        Statement stmt = conn.createStatement();
        int rowsAffected = stmt.executeUpdate(Constantes.requeteInsertionJeuDeDonnee); // Utilisez executeUpdate() ici
        System.out.println(rowsAffected + " lignes insérées.");
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
    }

    @Override
    public void flushDb() throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(Constantes.requeteFlushDb);
    }

    @Override
    public void getProgrammers() {
        String displayResult = "";
        for (Developpeur d : listeDeveloppeurs) {
            displayResult += "Id : " + d.getId() + " \nNom : " + d.getNom() + " \nPrenom : " + d.getPrenom()+ " \nAdresse : "
                    + d.getAdresse() + "\nResponsable : " + d.getResponsable() + "\nHobby : " + d.getHobby() + " \nNaissance : "
                    + d.getaNaissance() + " \nSalaire : " + d.getSalaire()+ " \nPrime : " + d.getPrime() + "\n"
                    + "-------------------------------------------------------------------- \n";
        }
        System.out.println(displayResult);
    }

    @Override
    public boolean getProgrammerById(int id) throws SQLException {
        String query = Constantes.requeteDeSelectionDesProgrammeurs + " WHERE ID = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        String displayProgammer = "";
        if(rs.next()) {
            int devId = rs.getInt("ID");
            for(Developpeur d : listeDeveloppeurs) {
                if(d.getId() == devId) {
                    displayProgammer += "Id : " + d.getId() + " \nNom : " + d.getNom() + " \nPrenom : " + d.getPrenom()+ " \nAdresse : "
                            + d.getAdresse() + "\nResponsable : " + d.getResponsable() + "\nHobby : " + d.getHobby() + " \nNaissance : "
                            + d.getaNaissance() + " \nSalaire : " + d.getSalaire()+ " \nPrime : " + d.getPrime() + "\n"
                            + "-------------------------------------------------------------------- \n";
                    System.out.println(displayProgammer);
                    return true;
                }
            }
        }
        return false;
    }

}
