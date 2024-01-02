import gui.screens.*;
import utility.UserInterface;

public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        createUI(userInterface);
    }
    public static void createUI(UserInterface userInterface){
        userInterface.setScreenInUI(new HomeScreen());
        userInterface.setScreenInUI(new BossScreen());
        userInterface.setScreenInUI(new WeaponScreen());
        userInterface.setScreenInUI(new ArmorScreen());
        userInterface.setScreenInUI(new IncantationScreen());
        userInterface.setScreenInUI(new SorceryScreen());
        userInterface.setScreenInUI(new CharacterScreen());
        userInterface.publishUI();
    }
}