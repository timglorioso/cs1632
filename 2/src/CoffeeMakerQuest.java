import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoffeeMakerQuest {

    private List<String> validCommands;

    public CoffeeMakerQuest() {
        validCommands = Arrays.asList("N", "S", "L", "I", "H", "D");
    }

    public static void main(String[] args) {
    }

    public List<String> getValidCommands() {
        return validCommands;
    }
}
