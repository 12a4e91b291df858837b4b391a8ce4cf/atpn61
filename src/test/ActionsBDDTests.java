package test;

import data.ActionsBDDImpl;
import exec.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ActionsBDDTests {

    ActionsBDDImpl actionsBDD = new ActionsBDDImpl();
    Menu menu = new Menu();

    @Test
    public void testMenuDisplay() {
        assertEquals("<<<<<<<<<<   MENU   >>>>>>>>>>" + "\n\n" +
                "1. Afficher tous les programmeurs" + "\n\n" +
                "2. Afficher un programmeur" + "\n\n" +
                "3. Supprimer un programmeur" + "\n\n" +
                "4. Ajouter un programmeur" + "\n\n" +
                "5. Modifier le salaire" + "\n\n" +
                "6. Quitter le programme" + "\n\n" +
                "7. Cette touche est réservée pour retourner sur le menu principal" + "\n\n" +
                "Quel est votre choix ? : ", menu.displayMenu());
    }

    public void
}