package org.example;

public class Main {
    public static void main(String[] args) {

        WaterPurifier myPurifier = new WaterPurifier("Kent", "Grand Plus");

        System.out.println("Brand: " + myPurifier.getBrand());
        System.out.println("Model: " + myPurifier.getModel());
        System.out.println("Water Level: " + myPurifier.getWaterLevel() + "%");

        myPurifier.switchOn();
        System.out.println("Purifier ON: " + myPurifier.isOn());

        myPurifier.purifyWater();
        myPurifier.checkWaterLevel();
        myPurifier.cleanFilter();
        myPurifier.refillWater();
        myPurifier.startFilter();
        myPurifier.stopFilter();

        myPurifier.switchOff();
        System.out.println("Purifier ON: " + myPurifier.isOn());
    }
}