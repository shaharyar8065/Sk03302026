package org.example;

import java.util.Objects;

public abstract class Appliance {
    private String brand;
    private String model;
    private boolean isOn;

    public Appliance(String brand, String model) {
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

    public abstract void purifyWater();

    public abstract void checkWaterLevel();

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
        if (!(o instanceof Appliance that)) return false;
        return isOn() == that.isOn() && Objects.equals(getBrand(), that.getBrand()) && Objects.equals(getModel(), that.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), isOn());
    }

    @Override
    public String toString() {
        return "WaterPurifier{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", isOn=" + isOn +
                '}';
    }
}
