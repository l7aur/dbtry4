package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;



public class CharacterScreen extends Screen {
    //Constructor
    public CharacterScreen(ConnectionModel cm) {
        super(Screens.CHARACTER_SCREEN, cm);
        this.setId(Screens.CHARACTER_SCREEN);
        this.columnNames = new String[]{ "id", "race_id", "weapon_id", "armor_id" };
        this.paintTable(getTable("character"));
    }
}
