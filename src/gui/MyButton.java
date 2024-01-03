package gui;

import utility.Images;
import utility.Screens;

import javax.swing.*;

public class MyButton extends JButton {
    private Screens id;

    public MyButton(Screens name, Images imageIcon) {
        super(imageIcon.getImageIcon());
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.setId(name);
        this.makeButtonImage();
    }
    public MyButton(Screens name){
        super("COMMENT SCREEN BUTTON");
        this.setId(name);
    }
    public MyButton(){
        super("INSERT COMMENT BUTTON");
    }
    public void makeButtonImage() {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
    }
    public Screens getId(){
        return this.id;
    }
    public void setId(Screens newName){
        this.id = newName;
    }
}
