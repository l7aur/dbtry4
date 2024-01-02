package gui.screens;

import gui.Screen;
import utility.Screens;

import javax.swing.*;

public class BossScreen extends Screen {
    public BossScreen(){
        super();
        this.setId(Screens.BOSS_SCREEN);
        JTextField text = new JTextField("boss screen");
        this.add(text);
    }
}
