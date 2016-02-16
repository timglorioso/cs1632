import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

public class CoffeeMakerQuestTest {

    /*
     * see requirement: FUN-ITERATION
     */
    @Test
    public void testAcceptsValidCommands() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        for (String command : Arrays.asList("N", "S", "L", "I", "H", "D")) {
            assertNotEquals("What?", testGame.respondToCommand(command));
        }
    }

    /*
     * see requirement: FUN-UNKNOWN-COMMAND
     */
    @Test
    public void testRespondsToEmptyCommand() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        String response = testGame.respondToCommand("");
        assertEquals("What?", response);
    }

    /*
     * see requirement: FUN-UNKNOWN-COMMAND
     */
    @Test
    public void testRespondsToInvalidCharactersCommand() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        String response = testGame.respondToCommand("5! {+");
        assertEquals("What?", response);
    }
 
    /*
     * see requirement: FUN-INPUT-CAPS
     */
    @Test
    public void testAcceptsUpperCaseCommand() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        String response = testGame.respondToCommand("H");
        assertNotEquals("What?", response);
    }

    /*
     * see requirement: FUN-INPUT-CAPS
     */
    @Test
    public void testAcceptsLowerCaseCommand() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        String response = testGame.respondToCommand("h");
        assertNotEquals("What?", response);
    }

    /*
     * see requirement: FUN-HELP
     */
    @Test
    public void testDisplaysHelpMessage() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        String helpMessage = String.join(System.getProperty("line.separator"),
            "The following single-character commands are at your disposal:",
            "N - move north, if possible",
            "S - move south, if possible",
            "L - look around the room for ingredients to pick up",
            "I - check your inventory",
            "D - mix the ingredients in your inventory and drink the result",
            "H - display this help message");
        String response = testGame.respondToCommand("H");
        assertEquals(helpMessage, response);
    }
}
