package utility;

import gui.MyButton;
import gui.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private Container container;
    private Screens currentCard = Screens.HOME_SCREEN;
    public UserInterface(){
        this.container = getContentPane();
        this.cardLayout = new CardLayout();
        this.container.setLayout(this.cardLayout);
    }
    public void publishUI() {
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void setScreenInUI(Screen screen) {
        try {
            if (screen.getId() == Screens.HOME_SCREEN) {
                screen.addArmorButton(this);
                screen.addBossButton(this);
            }
            else
                screen.addHomeButton(this);
            this.container.add(screen.getId().toString(), screen);
            System.out.println(screen.getId().toString());
        }
        catch (NullPointerException e) {
            System.out.println("No screen!");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Screens goToScreen = Screens.HOME_SCREEN;

        if(this.currentCard == Screens.HOME_SCREEN) {
            MyButton target = (MyButton) e.getSource();

            System.out.println("Target is " + target.getId().toString());
            switch (target.getId()){
                case Screens.ARMOR_SCREEN -> goToScreen = Screens.ARMOR_SCREEN;
                case Screens.BOSS_SCREEN -> goToScreen = Screens.BOSS_SCREEN;
//                default -> {
//                    System.out.println("Cannot reach that from home page!");
//                }
            }
        }
        cardLayout.show(container, goToScreen.toString());
    }
}
