package gui.screens;

import gui.Screen;
import utility.Screens;

import javax.swing.*;

public class CommentScreen extends Screen {
    //Constructor
    public CommentScreen(){
        super(Screens.COMMENT_SCREEN);
        String[] columnNames = { "id", "item_name", "comment" };
        JScrollPane scrollPane = new JScrollPane(this.setTable( "comments", columnNames, 3,false, null));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.content.add(scrollPane);
        this.setId(Screens.COMMENT_SCREEN);
    }
}
