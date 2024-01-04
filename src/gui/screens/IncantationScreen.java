package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;

import javax.swing.*;


public class IncantationScreen extends Screen {
    //Constructor
    public IncantationScreen(ConnectionModel cm){
        super(Screens.INCANTATION_SCREEN, cm);
        String[] columnNames = { "id", "description", "requirement_id", "granter_id", "image" };
        JScrollPane scrollPane = new JScrollPane(this.setTable("incantation", columnNames, false, null));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.INCANTATION_SCREEN);
    }
}
