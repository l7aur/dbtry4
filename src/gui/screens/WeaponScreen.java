package gui.screens;

import gui.Screen;
import utility.Screens;

import javax.swing.*;


public class WeaponScreen extends Screen {
    //Constructor
    public WeaponScreen(){
        super(Screens.WEAPON_SCREEN);
        String[] columnNames = { "id", "requirement_id", "image" };
        JScrollPane scrollPane = new JScrollPane(this.setTable("weapon", columnNames, 3,false, null));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.WEAPON_SCREEN);
    }
}
