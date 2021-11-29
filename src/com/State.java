package com;

public class State {
    public static Company currentCompany;
    public static void setActive(Company newCompany){
        System.out.println("StateChange " + newCompany.getText());
        currentCompany.isSelected = false;
        newCompany.isSelected = true;
        currentCompany.changeColor();
        newCompany.changeColor();
        currentCompany= newCompany;
    }
}
