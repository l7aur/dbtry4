package gui;

import utility.Images;
import utility.Screens;

import javax.swing.*;

public class MyButton extends JButton {
    private Screens id;

    public MyButton(Screens name, Images imageIcon) {
        super(imageIcon.getImageIcon());
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//        this.setBorderPainted(false);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setId(name);
    }
    public Screens getId(){
        return this.id;
    }
    public void setId(Screens newName){
        this.id = newName;
    }
}
