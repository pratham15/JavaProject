package com;
import pythonProcess.SentimentAnalysis.SentimentAnalysis;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class Main {
    public static void main(String[] args) {

        SentimentAnalysis.main();

        Company Adobe= new Company("Adobe", "Adobe.png", "@Adobe_pie.png", "ADBE", "@Adobe",659.72998),
                GS = new Company("Goldman Sachs", "GS.png", "@GoldmanSachs_pie.png", "GoldmanSachs", "@GoldmanSachs", 404.809),
                DELL = new Company("Dell", "DELL.png", "@Dell_pie.png", "DELL", "@Dell", 56.700),
                Schindler= new Company("Schindler", "schindler.jpg", "@SchindlerGroup_pie.png", "SCHP", "@SchindlerGroup",63.70),
                MS= new Company("Morgan Stanley", "MS.jpeg", "@MorganStanley_pie.png", "MorganStanley", "@MorganStanley", 100.209);


        State.currentCompany = Adobe;
        Adobe.isSelected = true;
        Adobe.changeColor();

        NavigationPanel bluePanel = new NavigationPanel(Adobe, GS, DELL, Schindler, MS);
        Border black = BorderFactory.createLineBorder(Color.white);


        MainPanel mainPanel = new MainPanel("Adobe", Adobe.getIcon());
        MyFrame frame = new MyFrame(bluePanel, mainPanel);
        RelatedCompaniesPanel.update(Adobe.relatedCompanies);
        SentimentPanel.update(Adobe.tweets);
        MainPanel.update(Adobe);
    }
}