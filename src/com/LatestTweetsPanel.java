package com;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LatestTweetsPanel extends JPanel {
    static Border white = BorderFactory.createLineBorder(Color.white);
    LatestTweetsPanel(){
        this.setBounds(500, 475, 500, 250);
        this.setLayout(null);
        this.setBorder(white);
        this.setBackground(Color.decode("#14004F"));
        JLabel heading = new JLabel("Recent Tweets");

    }
}
