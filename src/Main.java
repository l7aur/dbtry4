import gui.screens.*;
import utility.UserInterface;

public class Main {
    public static void main(String[] args) {
        //create the GUI
        UserInterface userInterface = new UserInterface();
        //set the pages in the GUI
        createUI(userInterface);
    }
    /**
     * insert into the UserInterface the pages/screens
     * @param userInterface represents the GUI we are going to display
     * */
    public static void createUI(UserInterface userInterface){
        userInterface.setScreenInUI(new HomeScreen());
        userInterface.setScreenInUI(new BossScreen());
        userInterface.setScreenInUI(new WeaponScreen());
        userInterface.setScreenInUI(new ArmorScreen());
        userInterface.setScreenInUI(new IncantationScreen());
        userInterface.setScreenInUI(new SorceryScreen());
        userInterface.setScreenInUI(new CharacterScreen());
        userInterface.setScreenInUI(new CommentScreen());
        userInterface.publishUI();
    }
}