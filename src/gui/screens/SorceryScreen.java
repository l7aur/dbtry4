package gui.screens;

import gui.Screen;
import utility.Screens;

import javax.swing.*;


public class SorceryScreen extends Screen {
    //Constructor
    public SorceryScreen(){
        super(Screens.SORCERY_SCREEN);
        String[] columnNames = { "id", "description", "requirement_id", "magic_id", "image" };
        JScrollPane scrollPane = new JScrollPane(this.setTable("sorcery", columnNames, 5, false, null));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.SORCERY_SCREEN);
    }
}
