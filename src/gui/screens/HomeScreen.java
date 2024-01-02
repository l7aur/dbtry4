package gui.screens;

import gui.Screen;
import utility.Screens;

import javax.swing.*;

public class HomeScreen extends Screen {
    public HomeScreen(){
        super();
        this.setId(Screens.HOME_SCREEN);
        JTextField text = new JTextField("home screen");
        this.add(text);
    }
}
