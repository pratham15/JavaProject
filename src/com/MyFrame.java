package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    MyFrame(Component ...C) {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1400, 800);
        this.setVisible(true);
        for(Component comp: C)
            this.add(comp);
    }
}