package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;



public class IncantationScreen extends Screen {
    //Constructor
    public IncantationScreen(ConnectionModel cm){
        super(Screens.INCANTATION_SCREEN, cm);
        this.setId(Screens.INCANTATION_SCREEN);
        this.columnNames = new String[]{ "id", "description", "requirement_id", "granter_id", "image" };
        this.paintTable(getTable("incantation"));
    }
}
