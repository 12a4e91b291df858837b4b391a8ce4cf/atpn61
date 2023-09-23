package data;
import java.sql.SQLException;

public interface ActionsBDD {
     public void openConnection() throws SQLException;
     public void createProgrammers() throws SQLException;
     public  void getProgrammers() throws SQLException;
     public void getProgrammerById(int id) throws SQLException;
}
