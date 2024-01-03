package gui.screens;

import gui.Screen;
import utility.Screens;

import javax.swing.*;


public class CharacterScreen extends Screen {
    //Constructor
    public CharacterScreen() {
        super(Screens.CHARACTER_SCREEN);
        String[] columnNames = { "id", "race_id", "weapon_id", "armor_id" };
        JScrollPane scrollPane = new JScrollPane(this.setTable("character", columnNames, 8,true, new int[] {2, 4, 5, 6, 7}));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.CHARACTER_SCREEN);
    }
}
