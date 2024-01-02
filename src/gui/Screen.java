package gui;

import backend.ConnectionModel;
import gui.buttons.*;
import utility.Screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Screen extends JPanel {
    protected ConnectionModel connectionModel = new ConnectionModel();
    private Screens id = Screens.SCREEN;
    private HomeButton currentScreenHomeButton;
    private ArmorButton currentScreenArmorButton;
    private BossButton currentScreenBossButton;
    private IncantationButton currentScreenIncantationButton;
    private SorceryButton currentScreenSorceryButton;
    private CharacterButton currentScreenCharacterButton;
    private WeaponButton currentScreenWeaponButton;
    protected JPanel header;
    protected JPanel footer;
    protected JPanel content;
    public Screen(Screens title) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new JPanel();
        footer = new JPanel();
        content = new JPanel();
        this.add(header);
        this.add(content);
        this.add(footer);
        //this.setPreferredSize(new Dimension(1080, 720));
        JLabel text = new JLabel(title.toString().toUpperCase().replace('_', ' '));
        this.header.add(text);
        connectionModel.connect();

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
//        this.footer.setLayout(new BorderLayout());
        this.content.setAlignmentX(Container.LEFT_ALIGNMENT);
        this.content.add(this.currentScreenHomeButton);
    }
    public void addArmorButton(ActionListener actionListener) {
        this.currentScreenArmorButton = new ArmorButton();
        this.currentScreenArmorButton.addActionListener(actionListener);
        this.content.add(this.currentScreenArmorButton);
    }
    public void addBossButton(ActionListener actionListener) {
        this.currentScreenBossButton = new BossButton();
        this.currentScreenBossButton.addActionListener(actionListener);
        this.content.add(this.currentScreenBossButton);
    }
    public void addSorceryButton(ActionListener actionListener) {
        this.currentScreenSorceryButton = new SorceryButton();
        this.currentScreenSorceryButton.addActionListener(actionListener);
        this.content.add(this.currentScreenSorceryButton);
    }
    public void addIncantationButton(ActionListener actionListener) {
        this.currentScreenIncantationButton = new IncantationButton();
        this.currentScreenIncantationButton.addActionListener(actionListener);
        this.content.add(this.currentScreenIncantationButton);
    }
    public void addWeaponButton(ActionListener actionListener) {
        this.currentScreenWeaponButton = new WeaponButton();
        this.currentScreenWeaponButton.addActionListener(actionListener);
        this.content.add(this.currentScreenWeaponButton);
    }
    public void addCharacterButton(ActionListener actionListener) {
        this.currentScreenCharacterButton = new CharacterButton();
        this.currentScreenCharacterButton.addActionListener(actionListener);
        this.content.add(this.currentScreenCharacterButton);
    }
}
