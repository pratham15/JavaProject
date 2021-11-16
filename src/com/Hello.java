package com;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Hello {

    public static void main(String[] args) {

        Labels HCL = new Labels("HCL", "HCL.png"),
                GS = new Labels("Goldman Sachs", "GS.png"),
                DELL = new Labels("Dell", "HCL.png"),
                TATA = new Labels("TATA", "TATA.png"),
                WIPRO = new Labels("WIPRO", "HCL.png");

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

        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(350, 0, 850, 800);
        mainPanel.setBackground(Color.blue);

        MyFrame frame = new MyFrame(bluePanel, mainPanel);
    }
}

