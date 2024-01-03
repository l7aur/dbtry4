package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;


public class ArmorScreen extends Screen {
    //Constructor
    public ArmorScreen(){
        super(Screens.ARMOR_SCREEN);
        String[] columnNames = { "id", "description", "requirement_id" };
        JScrollPane scrollPane = new JScrollPane(this.setTable("armor", columnNames, 3,false, null));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.ARMOR_SCREEN);
    }
}
