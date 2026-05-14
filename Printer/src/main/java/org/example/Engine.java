package org.example;

import java.util.Objects;

public abstract class Engine {
    private String engineModel;
    private byte cylinders;

    public Engine() {}

    public Engine(String engineModel, byte cylinders) {
        this.engineModel = engineModel;
        this.cylinders = cylinders;
    }

    abstract void start();
    abstract void stop();

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public byte getCylinders() {
        return cylinders;
    }

    public void setCylinders(byte cylinders) {
        this.cylinders = cylinders;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Engine engine)) return false;
        return getCylinders() == engine.getCylinders() && Objects.equals(getEngineModel(), engine.getEngineModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEngineModel(), getCylinders());
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineModel='" + engineModel + '\'' +
                ", cylinders=" + cylinders +
                '}';
    }
}
