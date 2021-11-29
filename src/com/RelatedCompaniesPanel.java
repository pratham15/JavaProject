package com;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RelatedCompaniesPanel extends JPanel {

    static Border white = BorderFactory.createLineBorder(Color.white);
    static JLabel[] companies;
    RelatedCompaniesPanel(){
        this.setBounds(750, 100, 290, 350);
        this.setBorder(white);
        this.setBackground(Color.decode("#14004F"));
        this.setLayout(null);
        JLabel container = new JLabel("Related Companies");
        container.setBounds(10, 5, 300, 50) ;
        container.setForeground(Color.white);
        container.setFont(new Font("", Font.BOLD, 25));

        companies = new JLabel[5];
        for(int i = 0; i < 5; ++i){
            companies[i] = new JLabel("NA");
            companies[i].setBounds(20, i * 50 + 50, 300, 50);
            companies[i].setFont(new Font("", Font.BOLD, 20));
            companies[i].setForeground(Color.white);
            this.add(companies[i]);
        }
        this.add(container);
    }
    public static void update(String []Company){
        for(int i = 0; i < Math.min(5, Company.length); ++i)
            companies[i].setText("->  " + Company[i]);
    }
}
