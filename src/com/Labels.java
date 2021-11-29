package com;

import javax.swing.*;
import java.awt.*;

public class Labels extends JButton {
	private static int counter = 0;
	private final String colorActive = "#002481",
			colorPassive = "#001A5B",
			directory = "/Users/prathamaggarwal/desktop/college/CSD213/Swing/static/";

	boolean isSelected = false, hover = false;

	private ImageIcon icon;
	Labels(String text, String URL) {
		icon = new ImageIcon(directory + URL);
		Image img = icon.getImage();
		img = img.getScaledInstance(60, 20, Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);

		this.setBounds(1, 250 + counter * 80, 348, 70);
		this.setIcon(icon);
		this.setIconTextGap(20);
		this.setText(text);
		this.setFont(new Font("Helvetica", Font.BOLD, 28));
		this.setOpaque(true);
		this.setBorderPainted(false);
		this.setBackground(Color.decode(colorPassive));
		this.setForeground(Color.white);
		this.setHorizontalAlignment(JButton.LEFT);
		this.setForeground(Color.decode("#C2BFBF"));
		counter++;
	}

	public ImageIcon getIcon(){
		return icon;
	}

	public void changeColor() {
		if (isSelected || hover) {
			this.setBackground(Color.decode(colorActive));
			this.setForeground(Color.white);
		} else {
			this.setBackground(Color.decode(colorPassive));
			this.setForeground(Color.decode("#C2BFBF"));
		}
	}


}