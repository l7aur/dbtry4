package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;



public class ArmorScreen extends Screen {
    //Constructor
    public ArmorScreen(ConnectionModel cm){
        super(Screens.ARMOR_SCREEN, cm);
        this.columnNames = new String[]{"id", "description", "requirement_id"};
        this.paintTable(getTable("armor"));
        this.setId(Screens.ARMOR_SCREEN);
    }
}
