import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

public class CoffeeMakerQuestPlayerTest {

    @Test
    public void testStringifiesEmptyInventory() {
        CoffeeMakerQuestPlayer testPlayer = new CoffeeMakerQuestPlayer();
        String inventoryString = testPlayer.inventoryToString();
        assertEquals("nothing", inventoryString);
    }

    @Test
    public void testStringifiesNonEmptyInventory() {
        CoffeeMakerQuestPlayer testPlayer = new CoffeeMakerQuestPlayer();
        testPlayer.addToInventory("cream");
        testPlayer.addToInventory("sugar");
        testPlayer.addToInventory("coffee");
        String inventoryString = testPlayer.inventoryToString();
        assertThat(inventoryString, anyOf(containsString("coffee"),
                                          containsString("cream"),
                                          containsString("sugar")));
    }
}
