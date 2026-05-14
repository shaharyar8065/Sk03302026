package org.example;

import java.util.Objects;

public class Printer extends Object {
    private String modelType;
    private boolean isOnline;
    private long paperCount;

    public Printer(String modelType, boolean isOnline, long paperCount) {
        this.modelType = modelType;
        this.isOnline = isOnline;
        this.paperCount = paperCount;
    }

    public void toggleConnection() {
        if (this.isOnline == true) {
            this.isOnline = false;
        } else {
            this.isOnline = true;
        }
    }

    public void addPaper(long sheets) {
        if (sheets < 1) {
            throw new IllegalArgumentException("Cannot add zero or negative paper");
        }
        this.paperCount = this.paperCount + sheets;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public long getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(long paperCount) {
        this.paperCount = paperCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Printer printer = (Printer) o;
        return isOnline() == printer.isOnline() && getPaperCount() == printer.getPaperCount() && Objects.equals(getModelType(), printer.getModelType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModelType(), isOnline(), getPaperCount());
    }

    @Override
    public String toString() {
        return "printer{" +
                "modelType='" + modelType + '\'' +
                ", isOnline=" + isOnline +
                ", paperCount=" + paperCount +
                '}';
    }
}
