package com;

import javax.swing.*;
import java.awt.*;

public class Labels extends JLabel{
    private static int counter = 0;
    Labels(String text){
        this.setBounds(0, 65 * counter + 200, 350 , 60);
        this.setText(text);
        this.setFont(new Font("Serif", Font.BOLD, 32));
        this.setForeground(Color.white);
        this.setOpaque(true);
        this.setBackground(Color.decode("#000BB2"));
        counter++;
    }
}
