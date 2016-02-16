import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

public class CoffeeMakerQuestPlayerTest {

    /*
     * This test ensures that a player's empty inventory is correctly
     * converted to a String.
     */
    @Test
    public void testStringifiesEmptyInventory() {
        CoffeeMakerQuestPlayer testPlayer = new CoffeeMakerQuestPlayer();
        String inventoryString = testPlayer.inventoryToString();
        assertEquals("nothing", inventoryString);
    }

    /*
     * This test ensures that a player's non-empty inventory is correctly
     * converted to a String, where non-empty implies any number of items.
     */
    @Test
    public void testStringifiesNonEmptyInventory() {
        CoffeeMakerQuestPlayer testPlayer = new CoffeeMakerQuestPlayer();
        String[] testItems = {"milk", "ice", "marshmallows"};
        testPlayer.addToInventory(testItems[0]);
        testPlayer.addToInventory(testItems[1]);
        testPlayer.addToInventory(testItems[2]);
        String inventoryString = testPlayer.inventoryToString();
        assertThat(inventoryString, anyOf(containsString(testItems[0]),
                                          containsString(testItems[1]),
                                          containsString(testItems[2])));
    }
}
