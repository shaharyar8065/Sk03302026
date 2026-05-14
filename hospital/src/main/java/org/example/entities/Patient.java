package org.example.entities;

import java.util.Objects;

public class Patient extends Person {



    private String disease;

    public Patient(String id, String name, String disease) {
        super(id, name);
        this.disease = disease;
    }

    @Override
    public String getRole() {
        return "PATIENT";
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Patient patient)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getDisease(), patient.getDisease());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDisease());
    }

    @Override
    public String toString() {
        return "Patient{" +
                "disease='" + disease + '\'' +
                '}';
    }
}
