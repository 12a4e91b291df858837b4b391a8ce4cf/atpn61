package exec;
import java.sql.*;


public class Main {
    /**
     * Point d'entrée du programme.
     * @throws SQLException Si une exception SQL est levée.
     */
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.printMenu();
    }

}
