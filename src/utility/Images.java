package utility;

import javax.swing.*;
import java.awt.*;

/**
 * enumeration of all permitted images
 */
public enum Images {
    ARMOR_ICON("./src/utility/images/armor.png"),
    HOME_ICON("./src/utility/images/home.png"),
    WEAPON_ICON("./src/utility/images/weapon.png"),
    INCANTATION_ICON("./src/utility/images/incantation.png"),
    SORCERY_ICON("./src/utility/images/sorcery.png"),
    CHARACTER_ICON("./src/utility/images/character.png"),
    BOSS_ICON("./src/utility/images/boss.png"),
    COMM_ICON("./src/utility/images/comm.png");
    private ImageIcon imageIcon;

    /**
     * Constructor, scales images to a desired dimension
     * @param path path to the image
     */
    Images(String path) {
        if(path != null) {
            this.imageIcon = new ImageIcon(path);
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            this.imageIcon = new ImageIcon(resizedImage);
        }
    }
    /* Getters, Setters and Utility */
    public ImageIcon getImageIcon() {
        return imageIcon;
    }
}
