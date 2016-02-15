import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

public class CoffeeMakerQuestTest {

    /*
     * see requirement: FUN-ITERATION
     */
    @Test
    public void testAcceptsValidCommand() {
        CoffeeMakerQuest testGame = new CoffeeMakerQuest();
        String command = testGame.getNextCommand();
        assertThat(command, anyOf(equalTo("N"), equalTo("S"), equalTo("L"),
                                  equalTo("I"), equalTo("H"), equalTo("D")));
    }
}
