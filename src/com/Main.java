package com;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {

        Company Adobe= new Company("Adobe", "Adobe.png", "@Adobe_pie.png"),
                GS = new Company("GoldmanSachs", "GS.png", "@GoldmanSachs_pie.png"),
                DELL = new Company("Dell", "HCL.png", "@Dell_pie.png"),
                Schindler= new Company("Schindler", "Schindler.png", "@SchindlerGroup_pie.png"),
                MS= new Company("Morgan Stanley", "MS.jpeg", "@MorganStanley_pie.png");

        State.currentCompany = Adobe;
        Adobe.isSelected = true;
        Adobe.changeColor();

        NavigationPanel bluePanel = new NavigationPanel(Adobe, GS, DELL, Schindler, MS);

        String directory = "/Users/prathamaggarwal/desktop/college/CSD213/Swing/src/pythonProcess/";


        Border black = BorderFactory.createLineBorder(Color.white);

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(350, 0, 1050, 770);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#14004F"));


        JPanel graph = new JPanel();
        graph.setBounds(20, 100, 600, 350);
        graph.setBorder(black);
        graph.setBackground(Color.decode("#14004F"));

        mainPanel.add(graph);
        mainPanel.add(new SentimentPanel("/Users/prathamaggarwal/desktop/college/CSD213/Swing/src/pythonProcess/@Adobe_pie.png"));
        MyFrame frame = new MyFrame(bluePanel, mainPanel);
    }
}