package data;
import java.sql.SQLException;

public interface ActionsBDD {
     public void openConnection() throws SQLException;
     public void createProgrammers() throws SQLException;
     public void flushDb() throws SQLException;
     public  void getProgrammers() throws SQLException;
     public boolean getProgrammerById(int id) throws SQLException;
     public boolean deleteProgrammerById(int id) throws SQLException;
     public  void addProgrammers(String Nom,String Prenom, String Adresse, String Pseudo,
                    String Responsable, String Hobby, int Annee_de_naissance,
                    int Salaire, int Prime) throws SQLException;
     public boolean modifySalaryById(int id , float Salaire) throws SQLException;

     public boolean doesProgrammeurExist(int id) throws SQLException;
}
