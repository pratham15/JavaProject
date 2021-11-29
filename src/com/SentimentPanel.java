package com;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SentimentPanel extends JPanel {
    static Border black = BorderFactory.createLineBorder(Color.white);
    static JLabel container;

    static JLabel[] recentTweets;

    public static void changeImage(ImageIcon graph){
       container.setIcon(graph);
    }

    SentimentPanel(String graphDir){
        ImageIcon graph = new ImageIcon(graphDir);
        container = new JLabel(graph);
        container.setBounds(0, 0, 400, 300);
        container.setText("Sentiment Analysis");
        container.setForeground(Color.white);
        container.setHorizontalTextPosition(JLabel.CENTER);
        container.setVerticalTextPosition(JLabel.TOP);
        container.setIconTextGap(-40);
        container.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));

        JLabel tweets = new JLabel("Recent Twitter Mentions");
        tweets.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        tweets.setForeground(Color.white);
        tweets.setBounds(425, 0, 400, 50);


        this.setLayout(null);
        this.setBounds(20, 470, 1000, 280);
        this.setBorder(black);
        this.setBackground(Color.decode("#14004F"));
        this.add(container);
        this.add(tweets);

        recentTweets = new JLabel[5];
        for(int i = 0; i < 5; ++i) {
            recentTweets[i] = new JLabel();
            recentTweets[i].setBounds(425, i * 40 + 50, 500, 50);
            recentTweets[i].setFont(new Font("", Font.BOLD, 16));
            recentTweets[i].setForeground(Color.white);
            this.add(recentTweets[i]);
        }
    }
    public static void update(String [] uTweets){
        for(int i = 0; i < Math.min(uTweets.length, 5); ++i)
            recentTweets[i].setText(uTweets[i]);
    }
}
