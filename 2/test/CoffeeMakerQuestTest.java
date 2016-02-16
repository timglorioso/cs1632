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
     * see requirement: FUN-INVENTORY
     */
    @Test
    public void testDisplaysPlayerInventory() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        String response = testGame.respondToCommand("I");
        assertThat(response,
            both(org.hamcrest.CoreMatchers.startsWith("You have "))
            .and(either(containsString("nothing"))
                .or(anyOf(containsString("coffee"),
                          containsString("cream"),
                          containsString("sugar")))));
    }

    /*
     * see requirement: FUN-HELP
     */
    @Test
    public void testDisplaysHelpMessage() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        String helpMessage = String.join(System.getProperty("line.separator"),
            "The following commands are at your disposal:",
            "N - move north, if possible",
            "S - move south, if possible",
            "L - look around the room for ingredients to pick up",
            "I - check which ingredients you've added to your inventory",
            "D - mix your ingredients and drink the result",
            "H - display this help message");
        String response = testGame.respondToCommand("H");
        assertEquals(helpMessage, response);
    }
}
