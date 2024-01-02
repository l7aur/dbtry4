package gui;

import gui.buttons.ArmorButton;
import gui.buttons.BossButton;
import gui.buttons.HomeButton;
import utility.Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Screen extends JPanel {
    private final int upscaleFactor = 20;
    private Screens id = Screens.SCREEN;
    private HomeButton currentScreenHomeButton;
    private ArmorButton currentScreenArmorButton;
    private BossButton currentScreenBossButton;
    public Screen() {
        super();
        this.setPreferredSize(new Dimension(50 * upscaleFactor, 20 * upscaleFactor));
    }
    public void setId(Screens newName) {
        this.id = newName;
    }
    public Screens getId(){
        return this.id;
    }
    public void addHomeButton(ActionListener actionListener) {
        this.currentScreenHomeButton = new HomeButton();
        this.currentScreenHomeButton.addActionListener(actionListener);
        this.add(this.currentScreenHomeButton);
    }
    public void addArmorButton(ActionListener actionListener) {
        this.currentScreenArmorButton = new ArmorButton();
        this.currentScreenArmorButton.addActionListener(actionListener);
        this.add(this.currentScreenArmorButton);
    }
    public void addBossButton(ActionListener actionListener) {
        this.currentScreenBossButton = new BossButton();
        this.currentScreenBossButton.addActionListener(actionListener);
        this.add(this.currentScreenBossButton);
    }
}
