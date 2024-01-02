import gui.screens.ArmorScreen;
import gui.screens.BossScreen;
import gui.screens.HomeScreen;
import utility.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.setScreenInUI(new HomeScreen());
        userInterface.setScreenInUI(new ArmorScreen());
        userInterface.setScreenInUI(new BossScreen());
        userInterface.publishUI();
    }
}