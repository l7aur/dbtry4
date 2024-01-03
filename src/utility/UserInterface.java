package utility;

import gui.MyButton;
import gui.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The support of the application
 * extends JFrame so that it can be displayed and used as a background for other elements
 * implements ActionListener to be able to move through pages/screens
 * */
public class UserInterface extends JFrame implements ActionListener {
    private CardLayout cardLayout; //use CardLayout so that all pages are displayed in the same frame
    private Container container; //the sandbox of the frame
    private Screens currentCard = Screens.HOME_SCREEN; //the page that is currently displayed
    /**
     * constructor
     * */
    public UserInterface(){
        super();
        this.container = this.getContentPane();
        this.cardLayout = new CardLayout();
        this.container.setLayout(this.cardLayout);
    }
    /**
     * makes the UserInterface visible, sets its dimension and associates the close of the GUI with the end of the application
     * */
    public void publishUI() {
        this.setSize(800, 600);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Adds the corresponding buttons inside the screen based on its class.
     * Checks if the screen sent as parameter is null and handles this exception.
     * Home Screen requires all buttons, while the other need only the home and insert buttons.
     * @param screen represents the screen whose GUI we are preparing
     */
    public void setScreenInUI(Screen screen) {

        try {
            if (screen.getId() == Screens.HOME_SCREEN) {
                //add all the buttons to other pages
                screen.addBossButton(this);
                screen.addWeaponButton(this);
                screen.addArmorButton(this);
                screen.addSorceryButton(this);
                screen.addIncantationButton(this);
                screen.addCharacterButton(this);
                screen.addCommentButton(this);
            }
            else {
                screen.addHomeButton(this);
                screen.addInsertButton();
            }
            //add the screen and its identifier into the deck of screens
            this.container.add(screen.getId().toString(), screen);
//debug            System.out.println(screen.getId().toString());
        }
        catch (NullPointerException e) {
            //better handling may be required
            System.out.println("No screen!");
        }
    }

    /**
     * Based on the button being pressed it redirects us to the correct screen by means of the id
     * @param e the event to be processed - button press
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Screens goToScreen = ((MyButton) e.getSource()).getId();
//debug            System.out.println("Target is " + target.getId().toString());
        cardLayout.show(container, goToScreen.toString());
    }
}
