package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;


public class IncantationScreen extends Screen {
    //Constructor
    public IncantationScreen(){
        super(Screens.INCANTATION_SCREEN);
        String[] columnNames = { "id", "description", "requirement_id", "granter_id", "image" };
        JScrollPane scrollPane = new JScrollPane(this.setTable("incantation", columnNames, 5,false, null));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.INCANTATION_SCREEN);
    }
}
