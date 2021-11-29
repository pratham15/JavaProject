package com.Miscellaneous;

import javax.swing.*;
import java.awt.*;

public class Logo extends ImageIcon {
    Logo(String URL){
        super(URL);
    }
    Logo(int height, int width, String URL){
        ImageIcon icon = new ImageIcon(URL);
        Image im = icon.getImage();
        im = im.getScaledInstance(height, width, Image.SCALE_SMOOTH);
    }
}
