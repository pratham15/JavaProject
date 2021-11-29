package com;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SentimentPanel extends JPanel {
    static Border black = BorderFactory.createLineBorder(Color.white);
    static JLabel container;

    public static void changeImage(ImageIcon graph){
       container.setIcon(graph);
    }

    SentimentPanel(String graphDir){
        ImageIcon graph = new ImageIcon(graphDir);
        container = new JLabel(graph);
        container.setBounds(0, 0, 400, 300);
        container.setText("Sentiment Analysis");
        container.setForeground(Color.white);
        container.setHorizontalTextPosition(JLabel.CENTER);
        container.setVerticalTextPosition(JLabel.TOP);
        container.setIconTextGap(-40);
        container.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));

        this.setLayout(null);
        this.setBounds(20, 470, 450, 280);
        this.setBorder(black);
        this.setBackground(Color.decode("#14004F"));
        this.add(container);
    }
}
