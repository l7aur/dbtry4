package utility;

import javax.swing.*;
import java.awt.*;

public enum Images {
    ARMOR_ICON("./src/utility/images/armor.png"),
    HOME_ICON("./src/utility/images/home.png"),
    WEAPON_ICON("./src/utility/images/weapon.png"),
    INCANTATION_ICON("./src/utility/images/incantation.png"),
    SORCERY_ICON("./src/utility/images/sorcery.png"),
    CHARACTER_ICON("./src/utility/images/character.png"),
    BOSS_ICON("./src/utility/images/boss.png");
    private ImageIcon imageIcon;
    Images(String path) {
        if(path != null) {
            this.imageIcon = new ImageIcon(path);
            Image image = imageIcon.getImage();
            Image resizedImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            this.imageIcon = new ImageIcon(resizedImage);
        }
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }
}
