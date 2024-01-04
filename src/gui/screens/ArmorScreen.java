package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;

import javax.swing.*;


public class ArmorScreen extends Screen {
    //Constructor
    public ArmorScreen(ConnectionModel cm){
        super(Screens.ARMOR_SCREEN, cm);
        String[] columnNames = { "id", "description", "requirement_id" };
        JScrollPane scrollPane = new JScrollPane(this.setTable("armor", columnNames,false, null));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.ARMOR_SCREEN);
    }
}
