package com;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import pythonProcess.SentimentAnalysis.*;
public class Main {
    public static void main(String[] args) {

        Company Adobe= new Company("Adobe", "Adobe.png", "@Adobe_pie.png", "ADBE", "@Adobe"),
                GS = new Company("Goldman Sachs", "GS.png", "@GoldmanSachs_pie.png", "GS", "@GoldmanSachs"),
                DELL = new Company("Dell", "DELL.png", "@Dell_pie.png", "DELL", "@Dell"),
                Schindler= new Company("Schindler", "schindler.jpg", "@SchindlerGroup_pie.png", "SCHP", "@SchindlerGroup"),
                MS= new Company("Morgan Stanley", "MS.jpeg", "@MorganStanley_pie.png", "MS", "@MorganStanley");


        State.currentCompany = Adobe;
        Adobe.isSelected = true;
        Adobe.changeColor();

        NavigationPanel bluePanel = new NavigationPanel(Adobe, GS, DELL, Schindler, MS);
        Border black = BorderFactory.createLineBorder(Color.white);


        MainPanel mainPanel = new MainPanel("Adobe", Adobe.getIcon());
        MyFrame frame = new MyFrame(bluePanel, mainPanel);
        RelatedCompaniesPanel.update(Adobe.relatedCompanies);
        SentimentPanel.update(Adobe.tweets);
    }
}