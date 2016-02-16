import java.util.Arrays;
import java.util.List;

public class CoffeeMakerQuest {

    private List<String> validCommands;

    public CoffeeMakerQuest() {
        validCommands = Arrays.asList("N", "S", "L", "I", "H", "D");
    }

    public static void main(String[] args) {
    }

    public String respondToCommand(String command) {
        String response = new String();
        if (!validCommands.contains(command.toUpperCase())) {
            response = "What?";
        }
        return response;
    }
}
