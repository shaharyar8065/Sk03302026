package org.example;

import java.util.Objects;

public class InkjetPrinter extends Printer {
    private boolean hasInk;
    private boolean isOnline;

    public InkjetPrinter(String modelType, boolean isOnline, long paperCount, boolean hasInk) {
        super(modelType, isOnline, paperCount);
        this.hasInk = hasInk;
        this.isOnline = isOnline;
    }
    public void connect() {
        if (this.hasInk) {
            this.isOnline = true;
        } else {
            throw new RuntimeException("Cannot connect: No ink!");
        }
    }
    public void refillInk(boolean isNewCartridge) {
        if (isNewCartridge == true) {
            this.hasInk = true;
        } else {
            this.hasInk = false;
        }
    }

    public boolean isHasInk() {
        return hasInk;
    }

    public void setHasInk(boolean hasInk) {
        this.hasInk = hasInk;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void isOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InkjetPrinter that)) return false;
        if (!super.equals(o)) return false;
        return isHasInk() == that.isHasInk() && isOnline() == that.isOnline();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isHasInk(), isOnline());
    }

    @Override
    public String toString() {
        return "InkjetPrinter{" +
                "hasInk=" + hasInk +
                '}';
    }
}
