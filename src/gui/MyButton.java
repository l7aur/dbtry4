package gui;

import utility.Screens;

import java.awt.*;

public class MyButton extends Button {
    private Screens id;
    public MyButton(Screens name) {
        super(name.toString().toUpperCase().replace('_', ' '));
        this.setId(name);
    }
    public Screens getId(){
        return this.id;
    }
    public void setId(Screens newName){
        this.id = newName;
    }
}
