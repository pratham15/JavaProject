package com;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import javax.swing.*;

public class Hello {

    public static void main(String[] args) {

        Labels HCL = new Labels("HCL", "HCL.png"),
                GS = new Labels("Goldman Sachs", "GS.png"),
                DELL = new Labels("Dell", "HCL.png"),
                TATA = new Labels("TATA", "TATA.png"),
                WIPRO = new Labels("WIPRO", "WIPRO.jpeg");

        Labels[] Companies = new Labels[5];


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


        String command[] = {"python", "A.py", "--company_handle", "@Dell"};
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.directory(new File("/Users/prathamaggarwal/Desktop/College/CSD213/Swing/src/pythonProcess/"));
        try {
            Process p = pb.start();
            BufferedReader reader = new BufferedReader( new InputStreamReader(p.getInputStream()));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line); }
            int exitCode = p.waitFor();
            System.out.println("Exited with code" + exitCode);
        } catch(Exception e) {
            e.printStackTrace();
        }


        String directory = "/Users/prathamaggarwal/desktop/college/CSD213/Swing/src/pythonProcess/";

        ImageIcon icon = new ImageIcon(directory + "@Dell_pie.png");
        JLabel img = new JLabel();
        img.setBounds(100,200, 700, 500);
        img.setIcon(icon);
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(350, 0, 850, 800);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.decode("#14004F"));
        mainPanel.add(img);

        MyFrame frame = new MyFrame(bluePanel, mainPanel);
    }
}

