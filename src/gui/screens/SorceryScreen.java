package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;

import javax.swing.*;


public class SorceryScreen extends Screen {
    //Constructor
    public SorceryScreen(ConnectionModel cm){
        super(Screens.SORCERY_SCREEN, cm);
        String[] columnNames = { "id", "description", "requirement_id", "magic_id", "image" };
        JScrollPane scrollPane = new JScrollPane(this.setTable("sorcery", columnNames, false, null));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.SORCERY_SCREEN);
    }
}
