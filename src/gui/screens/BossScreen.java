package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;



public class BossScreen extends Screen {
    //Constructor
    public BossScreen(ConnectionModel cm){
        super(Screens.BOSS_SCREEN, cm);
        this.setId(Screens.BOSS_SCREEN);
        this.columnNames = new String[]{ "id", "location_id", "weapon_id", "armor_id", "race_id", "image" };
        this.paintTable(getTable("boss"));
    }
}
