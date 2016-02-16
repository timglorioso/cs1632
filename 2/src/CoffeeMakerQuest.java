import java.util.Arrays;
import java.util.List;

public class CoffeeMakerQuest {

    private List<String> validCommands;
    private List<String> validCommandResponses;
    private String unknownCommandResponse;

    public CoffeeMakerQuest() {
        validCommands = Arrays.asList("N", "S", "L", "I", "H", "D");
        validCommandResponses = Arrays.asList(
            "",
            "",
            "",
            "",
            String.join(System.getProperty("line.separator"),
                "The following single-character commands are at your disposal:",
                "N - move north, if possible",
                "S - move south, if possible",
                "L - look around the room for ingredients to pick up",
                "I - check which ingredients you've added to your inventory",
                "D - mix your ingredients and drink the result",
                "H - display this help message"),
            "");
        unknownCommandResponse = "What?";
    }

    public static void main(String[] args) {
    }

    public String respondToCommand(String command) {
        String response = null;
        command = command.toUpperCase();
        for (int i = 0; i < validCommands.size(); i++) {
            if (validCommands.get(i).equals(command)) {
                response = validCommandResponses.get(i);
                break;
            }
        }
        if (response == null) {
            response = unknownCommandResponse;
        }
        return response;
    }
}
