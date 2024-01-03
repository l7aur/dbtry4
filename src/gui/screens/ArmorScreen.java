package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;


public class ArmorScreen extends Screen {
    public ArmorScreen(){
        super(Screens.ARMOR_SCREEN);
        JScrollPane scrollPane = new JScrollPane(this.setTable());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.ARMOR_SCREEN);
    }
    private JTable setTable() {
        String[] columnNames = { "id", "description", "requirement_id" };
        Tuple data = this.connectionModel.getDataFromDB("armor", 35,columnNames.length);
        MyTable table = new MyTable(data.getData(), columnNames);
        table.setTableConstraints(data.getWidth());
        return table;
    }
}
