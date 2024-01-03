package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;


public class ArmorScreen extends Screen {
    //Constructor
    public ArmorScreen(){
        super(Screens.ARMOR_SCREEN);
        JScrollPane scrollPane = new JScrollPane(this.setTable("armor"));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.ARMOR_SCREEN);
    }
    //Fetch data from database and display it into a table
    private JTable setTable(String name) { //TODO add @param columnNames and move into Screen
        String[] columnNames = { "id", "description", "requirement_id" };
        Tuple data = this.connectionModel.getDataFromDB(name, this.connectionModel.getNumberOfRows(name),columnNames.length);
        MyTable table = new MyTable(data.getData(), columnNames);
        table.setTableConstraints(data.getWidth());
        return table;
    }
}
