package org.example;

import java.util.Objects;

public class Fan {

    private  String brand;
    private boolean isSpinning;
    private long speedLevel;

    public Fan(String brand, boolean isSpinning, long speedLevel) {
        this.brand = brand;
        this.isSpinning = isSpinning;
        this.speedLevel = speedLevel;
    }

    public void setSpeed(long newSpeed) {
        if (newSpeed < 0 || newSpeed > 5) {
            throw new RuntimeException("Speed must be between 0 and 5");
        }
        this.speedLevel = newSpeed;
    }

    public void setMaxSpeed() {
        long maxLimit = 5;
        this.speedLevel = maxLimit;
        System.out.println("Maximum speed limit of Fan is 5");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fan fan = (Fan) o;
        return isSpinning == fan.isSpinning && speedLevel == fan.speedLevel && Objects.equals(brand, fan.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, isSpinning, speedLevel);
    }

    @Override
    public String toString() {
        return "fan{" +
                "brand='" + brand + '\'' +
                ", isSpinning=" + isSpinning +
                ", speedLevel=" + speedLevel +
                '}';
    }
}

