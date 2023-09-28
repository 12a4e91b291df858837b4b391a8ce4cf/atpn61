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
        int rowsAffected = stmt.executeUpdate(Constantes.requeteInsertionJeuDeDonnee);
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

    @Override
    public boolean deleteProgrammerById(int id) throws SQLException {
        String query = Constantes.requeteDeSuppression + " WHERE ID = ? ";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1,id);
        pstmt.executeUpdate();
        for(Developpeur d : listeDeveloppeurs) {
            if(d.getId() == id) {
                listeDeveloppeurs.remove(d);
                System.out.println("SUPPRESSION REUSSIE");
                return true;
            }
        }
        return false;
    }

    @Override
    public void addProgrammers(String nom,String prenom, String adresse, String pseudo,
                                  String responsable, String hobby, int anNaissance,
                                  int salaire, int prime) {
        String query = Constantes.requeteInsertion + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3,adresse);
            pstmt.setString(4, pseudo);
            pstmt.setString(5, responsable);
            pstmt.setString(6, hobby);
            pstmt.setInt(7, anNaissance);
            pstmt.setInt(8, salaire);
            pstmt.setInt(9, prime);

            pstmt.executeUpdate();

            int id = listeDeveloppeurs.size() + 1;
            Developpeur dev = new Developpeur(id, nom, prenom, adresse, responsable, hobby, anNaissance, salaire, prime);
            listeDeveloppeurs.add(dev);
            System.out.println("AJOUT REUSSI");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean doesProgrammeurExist(int id) {
        try {
            String query = "SELECT 1 FROM programmeur WHERE ID = ? LIMIT 1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    @Override
    public boolean modifySalaryById (int id, float Salaire) throws SQLException{
    String query ="UPDATE programmeur SET SALAIRE = ? WHERE ID = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setFloat(1,Salaire);
        pstmt.setInt(2, id);

        int rowsUpdated = pstmt.executeUpdate();
        for(Developpeur dev : listeDeveloppeurs) {
            if(dev.getId() == id) {
                dev.setSalaire(Salaire);
                System.out.println("MODIFICATION REUSSIE");
            }
        }
        return rowsUpdated>0;
    }

}
