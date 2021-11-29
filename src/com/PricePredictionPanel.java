package com;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PricePredictionPanel extends JPanel {
    static Border white = BorderFactory.createLineBorder(Color.white);
    static JLabel container;

    PricePredictionPanel(String dir){

        ImageIcon graph = new ImageIcon(dir);
        Image img = graph.getImage();
        img = img.getScaledInstance(700, 300, Image.SCALE_SMOOTH);
        graph = new ImageIcon(img);

        container = new JLabel();
        container.setBounds(0, 0, 700, 350);
        container.setText("Stock Price Prediction");
        container.setForeground(Color.white);
        container.setHorizontalTextPosition(JLabel.CENTER);
        container.setVerticalTextPosition(JLabel.TOP);
        container.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));

        container.setIcon(graph);
        this.setBounds(20, 100,710, 350);
        this.setBorder(white);
        this.setBackground(Color.decode("#14004F"));
        this.add(container);

    }
    public static void update(ImageIcon icon){
        container.setIcon(icon);
    }
}
