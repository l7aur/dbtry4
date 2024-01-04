package utility;

import gui.MyButton;
import gui.screens.CommentScreen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private CommentScreen commentScreen;
    private CardLayout cardLayout;
    private Container container;
    public MyActionListener(CommentScreen commentScreen, CardLayout cardLayout, Container container){
        super();
        this.container = container;
        this.cardLayout = cardLayout;
        this.commentScreen = commentScreen;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.commentScreen.refresh("comments");
        cardLayout.show(container, ((MyButton) e.getSource()).getId().toString());
    }
}
