import backend.ConnectionModel;
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
        ConnectionModel connectionModel = new ConnectionModel();
        CommentScreen commentScreen =  new CommentScreen(connectionModel);
        userInterface.setScreenInUI(new HomeScreen());
        userInterface.setScreenInUI(new BossScreen(connectionModel));
        userInterface.setScreenInUI(new WeaponScreen(connectionModel));
        userInterface.setScreenInUI(new ArmorScreen(connectionModel));
        userInterface.setScreenInUI(new IncantationScreen(connectionModel));
        userInterface.setScreenInUI(new SorceryScreen(connectionModel));
        userInterface.setScreenInUI(new CharacterScreen(connectionModel));
        userInterface.setCommentScreenInUI(commentScreen);
        userInterface.publishUI();
    }
}