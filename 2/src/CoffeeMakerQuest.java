import java.util.Arrays;
import java.util.List;

public class CoffeeMakerQuest {

    private CoffeeMakerQuestPlayer player;
    private List<String> validCommands;
    private List<String> responsesForValidCommands;
    private String responseForUnknownCommand;

    public CoffeeMakerQuest() {
        player = new CoffeeMakerQuestPlayer();
        validCommands = Arrays.asList("N", "S", "L", "I", "H", "D");
        responsesForValidCommands = Arrays.asList(
            "",
            "",
            "",
            "You have %s.",
            String.join(System.getProperty("line.separator"),
                "The following commands are at your disposal:",
                "N - move north, if possible",
                "S - move south, if possible",
                "L - look around the room for ingredients to pick up",
                "I - check which ingredients you've added to your inventory",
                "D - mix your ingredients and drink the result",
                "H - display this help message"),
            "");
        responseForUnknownCommand = "What?";
    }

    public static void main(String[] args) {
    }

    /*
     * tested by: testAcceptsValidCommands()
     *            testRespondsToEmptyCommand()
     *            testRespondsToInvalidCharactersCommand()
     *            testAcceptsUpperCaseCommand()
     *            testAcceptsLowerCaseCommand()
     *            testDisplaysPlayerInventory()
     *            testDisplaysHelpMessage()
     */
    public String respondToCommand(String command) {
        String response = null;
        command = command.toUpperCase();
        for (int i = 0; i < validCommands.size(); i++) {
            if (validCommands.get(i).equals(command)) {
                response = responsesForValidCommands.get(i);
                response = formatResponseForCommand(response, command);
                break;
            }
        }
        if (response == null) {
            response = responseForUnknownCommand;
        }
        return response;
    }

    private String formatResponseForCommand(String response, String command) {
        if ("I".equals(command)) {
            response = String.format(response, player.inventoryToString());
        }
        return response;
    }
}
