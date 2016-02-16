import java.util.ArrayList;
import java.util.List;

public class CoffeeMakerQuestPlayer {

    private List<String> inventory;

    public CoffeeMakerQuestPlayer() {
        inventory = new ArrayList<String>();
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public String inventoryToString() {
        String inventoryString = "nothing";
        if (!inventory.isEmpty()) {
            inventoryString = String.join(", ", inventory);
        }
        return inventoryString;
    }
}
