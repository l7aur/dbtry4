package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;



public class SorceryScreen extends Screen {
    //Constructor
    public SorceryScreen(ConnectionModel cm){
        super(Screens.SORCERY_SCREEN, cm);
        this.setId(Screens.SORCERY_SCREEN);
        this.columnNames = new String[]{ "id", "description", "requirement_id", "magic_id", "image" };
        this.paintTable(getTable("sorcery"));
    }
}
