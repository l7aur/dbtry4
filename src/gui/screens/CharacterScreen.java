package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;


public class CharacterScreen extends Screen {
    //Constructor
    public CharacterScreen() {
        super(Screens.CHARACTER_SCREEN);
        JScrollPane scrollPane = new JScrollPane(this.setTable());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.CHARACTER_SCREEN);
    }
    //Fetch data from database, filter unnecessary fields and display it into a table
    private JTable setTable() {
        String[] columnNames = { "id", "race_id", "weapon_id", "armor_id" };
        Tuple data = this.connectionModel.getDataFromDB("character",10, 8);
        data = data.filterData(new int[] {2, 4, 5, 6, 7}); //absolutely exclusive fields
        MyTable table = new MyTable(data.getData(), columnNames);
        table.setTableConstraints(data.getWidth());
        return table;
    }
}
