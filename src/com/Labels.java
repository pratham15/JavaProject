package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Labels extends JButton{
    private static int counter = 0;
    private final String colorActive = "#002481",
            colorPassive = "#001A5B",
            directory = "/Users/prathamaggarwal/desktop/college/CSD213/Swing/static/";

    boolean isSelected = false, hover = false;
    Labels(String text, String URL){
        ImageIcon icon = new ImageIcon(directory + URL);
        Image img = icon.getImage();
        img = img.getScaledInstance(60, 20, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        this.setBounds(1, 250 + counter * 80, 348, 70);
        this.setIcon(icon);
        this.setIconTextGap(20);
        this.setText(text);
        this.setFont(new Font("Serif", Font.BOLD, 28));
        this.setOpaque(true);
        this.setBorderPainted(false);
        this.setBackground(Color.decode(colorPassive));
        this.setForeground(Color.white);
        this.setHorizontalAlignment(JButton.LEFT);
        this.setForeground(Color.decode("#C2BFBF"));
        counter++;

        this.addMouseListener(new java.awt.event.MouseAdapter(){

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt){
                super.mouseEntered(evt);
                System.out.println("enter");
                hover = true;
                changeColor();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                System.out.println("Exit");
                hover = false;
                changeColor();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Clicked");
            }
        });
    }

    public void changeColor(){
        if(isSelected || hover) {
            this.setBackground(Color.decode(colorActive));
            this.setForeground(Color.white);
        }
        else {
            this.setBackground(Color.decode(colorPassive));
            this.setForeground(Color.decode("#C2BFBF"));
        }
    }
}