package com;

import pythonProcess.SentimentAnalysis.CleanTweets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Company extends Labels{
    private String sentimentGraphUrl;
    static CleanTweets tweet = new CleanTweets();
    final private static String dir = "/Users/prathamaggarwal/desktop/college/Sem 2/CSD213/Swing/src/pythonProcess/";
    public ImageIcon pieGraph, priceGraph;
    public String [] relatedCompanies, tweets;
    public double predictedClosingPrice;

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

    Company(String Text, String URL, String sentimentGraphUrl, String PricePredictionGraphURL, String Tweets, double closingPrice){
        super(Text, URL);
        this.sentimentGraphUrl = sentimentGraphUrl;
        this.addMouseListener(m);

        pieGraph = new ImageIcon(dir + "SentimentAnalysis/"+sentimentGraphUrl);
        priceGraph = new ImageIcon(dir + "PricePrediction/" + PricePredictionGraphURL + "_priceprediction.png");
        Image img = priceGraph.getImage();
        img = img.getScaledInstance(700, 300, Image.SCALE_SMOOTH);
        priceGraph = new ImageIcon(img);
        relatedCompanies = tweet.get_related_list(Tweets);
        tweets = tweet.get_related_list("bad_words", Tweets);

        this.predictedClosingPrice = closingPrice;
    }

    public ImageIcon getPieGraph(){
        return pieGraph;
    }

    protected void changeState() {
        State.setActive(this);
    }
}