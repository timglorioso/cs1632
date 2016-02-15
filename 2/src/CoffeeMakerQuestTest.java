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
    public void testRespondsToUnknownCommand() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        String response = testGame.respondToCommand("A");
        assertEquals("What?", response);
    }
}
