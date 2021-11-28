package com;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Company extends  Labels{
    MouseAdapter m = new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            changeState();
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

    Company(String Text, String URL){
        super(Text, URL);
        this.addMouseListener(m);
    }
}