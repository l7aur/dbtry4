package gui.screens;

import gui.Screen;
import utility.MyTable;
import utility.Screens;
import utility.Tuple;

import javax.swing.*;

public class CommentScreen extends Screen {
    //Constructor
    public CommentScreen(){
        super(Screens.COMMENT_SCREEN);
        JScrollPane scrollPane = new JScrollPane(this.setTable(this.getNumberOfRowsInTable()));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.COMMENT_SCREEN);
    }
    //Fetch data from database and display it into a table
    private JTable setTable(int numberOfRows) {
        String[] columnNames = { "id", "item_name", "comment" };
        try {
            Tuple data = this.connectionModel.getDataFromDB("comments", numberOfRows, columnNames.length);
            MyTable table = new MyTable(data.getData(), columnNames);
            table.setTableConstraints(data.getWidth());
            return table;
        }
        catch (NullPointerException e){
            return new MyTable((new Tuple(0,0)).getData(), columnNames);
        }
    }

    /**
     * @return the number of rows inside the 'comments' table in the database
     */
    private int getNumberOfRowsInTable() {
        return this.connectionModel.getNumberOfRows("comments");
    }
}
