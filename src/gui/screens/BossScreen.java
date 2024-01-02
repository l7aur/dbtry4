package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;


public class BossScreen extends Screen {
    public BossScreen(){
        super(Screens.BOSS_SCREEN);
        JScrollPane scrollPane = new JScrollPane(this.setTable());
//        scrollPane.setPreferredSize(new Dimension(400, 500));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.BOSS_SCREEN);
    }
    private JTable setTable() {
        String[] columnNames = { "id", "location_id", "weapon_id", "armor_id", "race_id", "image" };
        Tuple data = this.connectionModel.getDataFromDB("boss",28, 10);
        data = data.filterData(new int[] {2, 5, 6, 7, 8});
        MyTable table = new MyTable(data.getData(), columnNames);
        table.setTableConstraints(data.getWidth());
        return table;
    }
}
