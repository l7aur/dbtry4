package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;


public class SorceryScreen extends Screen {
    //Constructor
    public SorceryScreen(){
        super(Screens.SORCERY_SCREEN);
        JScrollPane scrollPane = new JScrollPane(this.setTable());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.SORCERY_SCREEN);
    }
    //Fetch data from database and display it into a table
    private JTable setTable() {
        String[] columnNames = { "id", "description", "requirement_id", "magic_id", "image" };
        Tuple data = this.connectionModel.getDataFromDB("sorcery", 12, 5);
        MyTable table = new MyTable(data.getData(), columnNames);
        table.setTableConstraints(data.getWidth());
        return table;
    }
}
