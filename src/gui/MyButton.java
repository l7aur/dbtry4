package gui;

import utility.Images;
import utility.Screens;

import javax.swing.*;

public class MyButton extends JButton {
    private Screens id;
    //Constructors
    public MyButton(Screens name, Images imageIcon) {
        //images that act as buttons
        super(imageIcon.getImageIcon());
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        this.setId(name);
        this.makeButtonImage();
    }
    public MyButton(Screens name){
        super("COMMENT SCREEN BUTTON");//TODO maybe change it to a picture
        this.setId(name);
    }
    public MyButton(){
        super("INSERT COMMENT BUTTON");
    }
    /* Getters, Setters and Utility */
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
