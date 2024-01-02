package gui.screens;

import gui.Screen;
import utility.Screens;

import javax.swing.*;

public class ArmorScreen extends Screen {
    public ArmorScreen(){
        super();
        this.setId(Screens.ARMOR_SCREEN);
        JTextField text = new JTextField("armor screen");
        this.add(text);
    }
}
