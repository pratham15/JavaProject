package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Company extends  Labels{
    private String sentimentGraphUrl;
    final private static String dir = "/Users/prathamaggarwal/desktop/college/CSD213/Swing/src/pythonProcess/";
    private ImageIcon pieGraph;
    MouseAdapter m = new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            changeState();
            SentimentPanel.changeImage(pieGraph);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            hover = true;
            changeColor();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            hover = false;
            changeColor();
        }
    };

    Company(String Text, String URL, String sentimentGraphUrl){
        super(Text, URL);
        this.sentimentGraphUrl = sentimentGraphUrl;
        this.addMouseListener(m);
        pieGraph = new ImageIcon(dir + sentimentGraphUrl);
    }

    public ImageIcon getPieGraph(){
        return pieGraph;
    }
    protected void changeState() {
        State.setActive(this);
    }
}