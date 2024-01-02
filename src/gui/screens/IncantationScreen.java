package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;


public class IncantationScreen extends Screen {
    public IncantationScreen(){
        super(Screens.INCANTATION_SCREEN);
        JScrollPane scrollPane = new JScrollPane(this.setTable());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.INCANTATION_SCREEN);
    }
    private JTable setTable() {
        String[] columnNames = { "id", "description", "requirement_id", "granter_id", "image" };
        Tuple data = this.connectionModel.getDataFromDB("incantation", 42, 5);
        MyTable table = new MyTable(data.getData(), columnNames);
        table.setTableConstraints(data.getWidth());
        return table;
    }
}
