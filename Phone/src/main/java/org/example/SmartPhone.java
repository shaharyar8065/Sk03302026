package org.example;

import java.util.Objects;

public class SmartPhone extends Phone implements Chargeable{
    private int batteryLevel;
    private boolean isCharging;

    public SmartPhone(String brand, String model) {
        super(brand, model);
        this.batteryLevel = 50;
        this.isCharging = false;
    }
    static {
        System.out.println("this is the static");
    }


    @Override
    public void makeCall(String number) {
        System.out.println("Calling " + number);
    }

    @Override
    public void sendMessage(String number, String text) {
        System.out.println("Message sent to :" + number + text);
    }


    public void takePhoto() {
        if (isOn()) {
            System.out.println("Photo captured!");
        }
    }

    public void connectToWifi(String networkName) {
        if (isOn()) {
            System.out.println("Connected to: " + networkName);
        }
    }

    @Override
    public void charge() {
        isCharging = true;
        batteryLevel = 100;
        System.out.println("Charging... Battery: " + batteryLevel + "%");
    }

    @Override
    public void plugOut() {
        isCharging = false;
        System.out.println("Unplugged. Battery: " + batteryLevel + "%");
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public boolean isCharging() {
        return isCharging;
    }

    public void setCharging(boolean charging) {
        isCharging = charging;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SmartPhone that)) return false;
        if (!super.equals(o)) return false;
        return getBatteryLevel() == that.getBatteryLevel() && isCharging() == that.isCharging();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBatteryLevel(), isCharging());
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "batteryLevel=" + batteryLevel +
                ", isCharging=" + isCharging +
                '}';
    }
}
