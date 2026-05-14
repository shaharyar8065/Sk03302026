package org.example;

import java.util.Objects;

public class SmartFan extends Fan {
    long timerMinutes;
    boolean isAutoOffEnabled;

    public SmartFan(String brand, boolean isSpinning, long speedLevel, long timerMinutes) {
        super(brand, isSpinning, speedLevel);
        this.timerMinutes = timerMinutes;
        this.isAutoOffEnabled = false;
    }
   // static {
 //       System.out.println("hello");
 //   }

    public void updateTimer(long addedMinutes) {
        if (addedMinutes < 1) {
            throw new RuntimeException("Invalid time");
        }

        this.timerMinutes = this.timerMinutes + addedMinutes;

        if (this.timerMinutes > 60) {
            this.isAutoOffEnabled = true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartFan smartfan = (SmartFan) o;
        return timerMinutes == smartfan.timerMinutes && isAutoOffEnabled == smartfan.isAutoOffEnabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timerMinutes, isAutoOffEnabled);
    }

    @Override
    public String toString() {
        return "smartfan{" +
                "timerMinutes=" + timerMinutes +
                ", isAutoOffEnabled=" + isAutoOffEnabled +
                '}';
    }
}
