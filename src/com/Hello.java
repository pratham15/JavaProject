package com;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hello {

    public static void main(String[] args) {


        JLabel WIPRO = new Labels("WIPRO");
        JLabel HCL = new Labels("HCL");
        JLabel TATA = new Labels("TATA");
        JLabel INFOSYS = new Labels("INFOSYS");

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(0, 0, 350,800 );
        bluePanel.setLayout(null);

        bluePanel.add(WIPRO);
        bluePanel.add(HCL);
        bluePanel.add(TATA);
        bluePanel.add(INFOSYS);

        MyFrame frame = new MyFrame(bluePanel);
    }
}

