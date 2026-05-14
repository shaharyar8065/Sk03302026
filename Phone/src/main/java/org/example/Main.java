package org.example;

public class Main {
    public static void main(String[] args) {

        SmartPhone myPhone = new SmartPhone("Samsung", "Galaxy ");

        System.out.println("Brand: " + myPhone.getBrand());
        System.out.println("Model: " + myPhone.getModel());
        System.out.println("Battery: " + myPhone.getBatteryLevel() + "%");

        myPhone.switchOn();
        System.out.println("Phone ON: " + myPhone.isOn());

        myPhone.makeCall("123-456-7890");
        myPhone.sendMessage("123-456-7890 " , " Hello!");
        myPhone.takePhoto();
        myPhone.connectToWifi("HomeWifi");
        myPhone.plugOut();
        myPhone.charge();
    }
}