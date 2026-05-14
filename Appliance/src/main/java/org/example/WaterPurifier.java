package org.example;

import java.util.Objects;

public class WaterPurifier extends Appliance implements Filterable {

    private int waterLevel;
    private boolean isFiltering;
    private boolean needsRefill;

    public WaterPurifier(String brand, String model) {
        super(brand, model);
        this.waterLevel = 50;
        this.isFiltering = false;
        this.needsRefill = false;
    }

    @Override
    public void purifyWater() {
        if (isOn()) {
            isFiltering = true;
            waterLevel = waterLevel - 10;
            System.out.println("Purifying water... Water Level: " + waterLevel + "%");
        }
    }

    @Override
    public void checkWaterLevel() {
        if (isOn()) {
            int currentLevel = waterLevel;
            if (currentLevel < 20) {
                needsRefill = true;
                System.out.println("Water level low! Needs refill.");
            } else {
                System.out.println("Water level is fine: " + waterLevel + "%");
            }
        }
    }

    public void cleanFilter() {
        if (isOn()) {
            isFiltering = false;
            isFiltering = true;
            System.out.println("Filter cleaned successfully.");
        }
    }

    public void refillWater() {
        if (isOn()) {
            waterLevel = 100;
            needsRefill = false;
            System.out.println("Water refilled. Water Level: " + waterLevel + "%");
        }
    }


@Override
    public void startFilter() {
        isFiltering = true;
        waterLevel = 100;
        System.out.println("Filter started. Water Level: " + waterLevel + "%");
    }
@Override
    public void stopFilter() {
        isFiltering = false;
        System.out.println("Filter stopped.");
    }


    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public boolean isFiltering() {
        return isFiltering;
    }

    public void setFiltering(boolean filtering) {
        isFiltering = filtering;
    }

    public boolean isNeedsRefill() {
        return needsRefill;
    }

    public void setNeedsRefill(boolean needsRefill) {
        this.needsRefill = needsRefill;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof WaterPurifier that)) return false;
        if (!super.equals(o)) return false;
        return getWaterLevel() == that.getWaterLevel() && isFiltering() == that.isFiltering() && isNeedsRefill() == that.isNeedsRefill();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWaterLevel(), isFiltering(), isNeedsRefill());
    }

    @Override
    public String toString() {
        return "WaterPurifier{" +
                "waterLevel=" + waterLevel +
                ", isFiltering=" + isFiltering +
                ", needsRefill=" + needsRefill +
                '}';
    }
}