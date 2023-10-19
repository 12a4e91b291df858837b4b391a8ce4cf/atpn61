package test;

import data.ActionsBDDImpl;
import exec.Menu;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

public class ActionsBDDTests {
    ActionsBDDImpl actionsBDD = new ActionsBDDImpl();
    Menu menu = new Menu();

    @BeforeEach
    public void setUp() throws Exception {
        actionsBDD.openConnection();
        actionsBDD.flushDb();
        actionsBDD.createProgrammers();
    }

    @AfterEach
    public void tearDown() throws Exception {
        actionsBDD.flushDb();
        actionsBDD = null;
    }

    @Test
    public void runTests() throws Exception {
        testMenuDisplay();
        testAddProgrammers();
        testCreateProgrammer();
        testDoesProgrammerExists();
        testGetProgrammersById();
        testModifySalaryById();
        testDeleteProgrammerById();
    }
    public void testAddProgrammers() {
            actionsBDD.addProgrammers("Test", "User", "123 Test St", "tuser", "Test Boss", "Reading", 1990, 50000, 1500);
            assertTrue(actionsBDD.doesProgrammeurExist(ActionsBDDImpl.getListDevelopper().size()));
        }
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
    public void testCreateProgrammer() throws Exception {
        assertFalse(ActionsBDDImpl.getListDevelopper().isEmpty());
    }
    public void testDoesProgrammerExists() throws Exception {
            int indexOfLastProgrammer = ActionsBDDImpl.getListDevelopper().size();
            int indexOfNotExistingProgrammer = ActionsBDDImpl.getListDevelopper().size()+1;

            assertTrue(actionsBDD.doesProgrammeurExist(indexOfLastProgrammer));
            assertFalse(actionsBDD.doesProgrammeurExist(indexOfNotExistingProgrammer));
    }
    public void testGetProgrammersById() throws Exception {
            assertTrue(actionsBDD.getProgrammerById(ActionsBDDImpl.getListDevelopper().size()));
            assertFalse(actionsBDD.getProgrammerById(ActionsBDDImpl.getListDevelopper().size()+1));
    }
    public void testModifySalaryById() throws Exception {
            assertTrue(actionsBDD.modifySalaryById(1, 65000));
            assertEquals(65000, ActionsBDDImpl.getListDevelopper().get(0).getSalaire());
    }
    public void testDeleteProgrammerById() throws Exception {
            int lastId = ActionsBDDImpl.getListDevelopper().size();
            assertTrue(actionsBDD.deleteProgrammerById(lastId));
            assertFalse(actionsBDD.doesProgrammeurExist(lastId));
    }
}



