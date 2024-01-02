package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;


public class WeaponScreen extends Screen {
    public WeaponScreen(){
        super(Screens.WEAPON_SCREEN);
        JScrollPane scrollPane = new JScrollPane(this.setTable());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.WEAPON_SCREEN);
    }

    private JTable setTable() {
        String[] columnNames = { "id", "requirement_id", "image" };
        Tuple data = this.connectionModel.getDataFromDB("weapon", 81/*idk de ce +4*/, 3);
        MyTable table = new MyTable(data.getData(), columnNames);
        table.setTableConstraints(data.getWidth());
        return table;
    }
}
