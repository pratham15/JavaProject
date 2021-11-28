package com;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {

        Company Adobe= new Company("Adobe", "Adobe.png"),
                GS = new Company("GoldmanSachs", "GS.png"),
                DELL = new Company("Dell", "HCL.png"),
                Schindler= new Company("Schindler", "Schindler.png"),
                MS= new Company("Morgan Stanley", "MS.jpeg");

        State.CurrentLabel = Adobe;
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.decode("#14004F"));
        bluePanel.setBounds(0, 0, 350,770 );
        bluePanel.setLayout(null);
        bluePanel.add(Adobe);
        bluePanel.add(GS);
        bluePanel.add(DELL);
        bluePanel.add(Schindler);
        bluePanel.add(MS);

        Adobe.isSelected = true;
        Adobe.changeColor();


        String directory = "/Users/prathamaggarwal/desktop/college/CSD213/Swing/src/pythonProcess/";
        ImageIcon icon = new ImageIcon(directory + "@Dell_pie.png");
        JLabel img = new JLabel();
        img.setBounds(100,200, 700, 500);
        img.setIcon(icon);

        Border black = BorderFactory.createLineBorder(Color.white);
        bluePanel.setBorder(black);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(350, 0, 1050, 770);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#14004F"));

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

        bluePanel.add(logo);
        bluePanel.add(logoBot);

        JPanel graph = new JPanel();
        graph.setBounds(20, 100, 600, 350);
        graph.setBorder(black);
        graph.setBackground(Color.decode("#14004F"));

        mainPanel.add(graph);
        mainPanel.add(new SentimentPanel("/Users/prathamaggarwal/desktop/college/CSD213/Swing/src/pythonProcess/@Dell_pie.png"));
        MyFrame frame = new MyFrame(bluePanel, mainPanel);
    }
}