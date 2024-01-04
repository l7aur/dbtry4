package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;

import javax.swing.*;


public class BossScreen extends Screen {
    //Constructor
    public BossScreen(ConnectionModel cm){
        super(Screens.BOSS_SCREEN, cm);
        String[] columnNames = { "id", "location_id", "weapon_id", "armor_id", "race_id", "image" };
        JScrollPane scrollPane = new JScrollPane(this.setTable("boss", columnNames,true, new int[]{2, 5, 6, 7, 8}));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.BOSS_SCREEN);
    }
}
