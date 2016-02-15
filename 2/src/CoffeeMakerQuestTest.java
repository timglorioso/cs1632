import java.util.List;

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
        List<String> commands = testGame.getValidCommands();
        assertThat(commands, hasItems("N", "S", "L", "I", "H", "D"));
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
