import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoffeeMakerQuest {

    public static void main(String[] args) {
    }

    public String respondToCommand(String command) {
        String response = new String();
        if (!validCommands.contains(command)) {
            response = "What?";
        }
        return response;
    }
}
