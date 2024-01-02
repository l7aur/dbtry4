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
    private JPanel mainPanel;
    private Screens currentCard = Screens.HOME_SCREEN;
    public UserInterface(){
        this.container = this.getContentPane();
        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.container.setLayout(this.cardLayout);
    }
    public void publishUI() {
        this.setSize(800, 600);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void setScreenInUI(Screen screen) {

        try {
            if (screen.getId() == Screens.HOME_SCREEN) {
                screen.addBossButton(this);
                screen.addWeaponButton(this);
                screen.addArmorButton(this);
                screen.addSorceryButton(this);
                screen.addIncantationButton(this);
                screen.addCharacterButton(this);
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
                case Screens.BOSS_SCREEN -> goToScreen = Screens.BOSS_SCREEN;
                case Screens.WEAPON_SCREEN -> goToScreen = Screens.WEAPON_SCREEN;
                case Screens.ARMOR_SCREEN -> goToScreen = Screens.ARMOR_SCREEN;
                case Screens.SORCERY_SCREEN -> goToScreen = Screens.SORCERY_SCREEN;
                case Screens.INCANTATION_SCREEN -> goToScreen = Screens.INCANTATION_SCREEN;
                case Screens.CHARACTER_SCREEN -> goToScreen = Screens.CHARACTER_SCREEN;
//                default -> {
//                    System.out.println("Cannot reach that from home page!");
//                }
            }
        }
        cardLayout.show(container, goToScreen.toString());
    }
}
