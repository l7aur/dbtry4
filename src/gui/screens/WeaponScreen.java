package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;

public class WeaponScreen extends Screen {
    //Constructor
    public WeaponScreen(ConnectionModel cm){
        super(Screens.WEAPON_SCREEN, cm);
        this.setId(Screens.WEAPON_SCREEN);
        this.columnNames = new String[]{ "id", "requirement_id", "image" };
        this.paintTable(getTable("weapon"));
    }
}
