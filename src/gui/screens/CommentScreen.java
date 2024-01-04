package gui.screens;

import backend.ConnectionModel;
import gui.Screen;
import utility.Screens;

public class CommentScreen extends Screen {
    //Constructor
    public CommentScreen(ConnectionModel cm) {
        super(Screens.COMMENT_SCREEN, cm);
        this.setId(Screens.COMMENT_SCREEN);
        this.columnNames = new String[]{"id", "item_name", "comment"};
        this.paintTable(getTable("comments"));
    }
}
