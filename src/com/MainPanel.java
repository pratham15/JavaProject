package com;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainPanel extends JPanel {
    static JLabel mainLogo;
    static JLabel predictedText;
    static JLabel predictedStockPrice;
    static Border white = BorderFactory.createLineBorder(Color.white);
    MainPanel(String Company, ImageIcon Logo){
        this.setBounds(350, 0, 1050, 770);
        this.setLayout(null);
        this.setBackground(Color.decode("#14004F"));

        mainLogo = new JLabel();
        mainLogo.setText(Company);
        mainLogo.setIcon(Logo);
        mainLogo.setFont(new Font("",Font.BOLD, 28));
        mainLogo.setIconTextGap(20);
        mainLogo.setForeground(Color.white);
        mainLogo.setBounds(30, 10, 300, 100);

        predictedText = new JLabel();
        predictedText.setText("Predicted Closing Value: ");
        predictedText.setFont(new Font("",Font.BOLD, 28));
        predictedText.setForeground(Color.decode("#FF630C"));
        predictedText.setBounds(400, 10, 400, 100);

        predictedStockPrice= new JLabel();
        predictedStockPrice.setText("100");
        predictedStockPrice.setFont(new Font("",Font.BOLD, 28));
        predictedStockPrice.setForeground(Color.white);
        predictedStockPrice.setBounds(750, 10, 200, 100);

        this.add(new PricePredictionPanel("/Users/prathamaggarwal/desktop/college/CSD213/Swing/src/pythonProcess/PricePrediction/ADBE_priceprediction.png"));
        this.add(mainLogo);
        this.add(predictedText);
        this.add(predictedStockPrice);
        this.add(new SentimentPanel("/Users/prathamaggarwal/desktop/college/CSD213/Swing/src/pythonProcess/SentimentAnalysis/@Adobe_pie.png"));
        this.add(new RelatedCompaniesPanel());
        //this.add(new LatestTweetsPanel());
    }
    public static void update(Company c){
        mainLogo.setText(c.getText());
        mainLogo.setIcon(c.getIcon());
        predictedStockPrice.setText(String.valueOf(c.predictedClosingPrice));
    }

}
