import java.util.ArrayList;
import java.util.List;

public class CoffeeMakerQuestPlayer {

    private List<String> inventory;

    public CoffeeMakerQuestPlayer() {
        inventory = new ArrayList<String>();
    }

    /*
     * Note that this method is NOT tested because it simply calls add() on
     * the Java SDK's ArrayList implementation.
     */
    public void addToInventory(String item) {
        inventory.add(item);
    }

    /*
     * tested by: testStringifiesEmptyInventory()
     *            testStringifiesNonEmptyInventory()
     */
    public String inventoryToString() {
        String inventoryString = "nothing";
        if (!inventory.isEmpty()) {
            inventoryString = String.join(", ", inventory);
        }
        return inventoryString;
    }
}
