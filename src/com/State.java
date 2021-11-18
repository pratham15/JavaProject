package com;

public class State {
    public static Labels CurrentLabel;
    public static void setActive(Labels newLabel) {
        System.out.println("StateChange " + newLabel.getText());
        CurrentLabel.isSelected =false;
        newLabel.isSelected = true;
        CurrentLabel.changeColor();
        newLabel.changeColor();
        CurrentLabel = newLabel;
    }
}
