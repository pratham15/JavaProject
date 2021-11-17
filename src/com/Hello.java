package com;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.swing.*;
import javax.swing.border.Border;

public class Hello {

    public static void main(String[] args) {

        Labels HCL = new Labels("HCL", "HCL.png"),
                GS = new Labels("Goldman Sachs", "GS.png"),
                DELL = new Labels("Dell", "HCL.png"),
                TATA = new Labels("TATA", "TATA.png"),
                WIPRO = new Labels("WIPRO", "WIPRO.jpeg");

        Labels[] Companies = new Labels[5];

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.decode("#14004F"));
        bluePanel.setBounds(0, 0, 350,800 );
        bluePanel.setLayout(null);
        bluePanel.add(HCL);
        bluePanel.add(GS);
        bluePanel.add(DELL);
        bluePanel.add(TATA);
        bluePanel.add(WIPRO);

        HCL.isSelected = true;
        HCL.changeColor();

        String directory = "/Users/prathamaggarwal/desktop/college/CSD213/Swing/src/pythonProcess/";
        ImageIcon icon = new ImageIcon(directory + "@Dell_pie.png");
        JLabel img = new JLabel();
        img.setBounds(100,200, 700, 500);
        img.setIcon(icon);

        Border black = BorderFactory.createLineBorder(Color.white);
        bluePanel.setBorder(black);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(350, 0, 1050, 800);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#14004F"));
        //mainPanel.add(img);

        JPanel graph = new JPanel();
        graph.setBounds(20, 100, 500, 400);
        graph.setBorder(black);
        graph.setBackground(Color.decode("#14004F"));


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
        mainPanel.add(graph);
        MyFrame frame = new MyFrame(bluePanel, mainPanel);
    }
}

