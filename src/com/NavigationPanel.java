package com;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NavigationPanel extends JPanel {
    NavigationPanel(JButton... companies) {
        this.setBackground(Color.decode("#14004F"));
        this.setBounds(0, 0, 350, 770);
        this.setLayout(null);
        this.setBorder((Border) BorderFactory.createLineBorder(Color.white));
        for (JButton c : companies)
            this.add(c);

        JLabel logo = new JLabel("STOCK MARKET"), logoBot = new JLabel("ANALYSIS");
        logo.setBounds(75, 10, 300, 100);
        logo.setFont(new Font("Raleway", Font.BOLD, 30));
        logo.setForeground(Color.white);

        logoBot.setBounds(75, 40, 300, 200);
        logoBot.setForeground(Color.orange);
        logoBot.setFont(new Font("Raleway", Font.BOLD, 30));

        ImageIcon logoIcon = new ImageIcon( "/Users/prathamaggarwal/desktop/college/CSD213/Swing/static/Logo.jpeg");
        Image im = logoIcon.getImage();
        im = im.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(im);
        logoBot.setIcon(logoIcon);
        logoBot.setHorizontalTextPosition(JLabel.CENTER);
        logoBot.setVerticalTextPosition(JLabel.TOP);

        this.add(logo);
        this.add(logoBot);
    }
}
