package com;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(Component C) {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1200, 800);
        this.setVisible(true);
        this.add(C);
    }
}