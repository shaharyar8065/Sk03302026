package org.example;

import java.util.Objects;

public abstract class Phone {
    private String brand;
    private String model;
    private boolean isOn;

    public Phone(){}

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isOn = false;
    }

    public void switchOn() {
        isOn = true;
    }

    public void switchOff() {
        isOn = false;
    }

    public abstract void makeCall (String number);

    public abstract void sendMessage (String number, String text);

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Phone phone)) return false;
        return isOn() == phone.isOn() && Objects.equals(getBrand(), phone.getBrand()) && Objects.equals(getModel(), phone.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), isOn());
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", isOn=" + isOn +
                '}';
    }
}
