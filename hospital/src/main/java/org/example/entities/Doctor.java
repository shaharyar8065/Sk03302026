package org.example.entities;

import java.util.Objects;

public class Doctor extends Person{

    private String specialization;

    public Doctor(String id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    @Override
    public String getRole() {
        return "DOCTOR";
    }
    // method overloading
    public void prescribe(Patient patient) {
        System.out.println("Dr. " + getName() + " prescribed rest for " + patient.getName());
    }

    public void prescribe(Patient patient, String medicine) {
        System.out.println("Dr. " + getName() + " prescribed " + medicine
                + " for " + patient.getName());
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specialization='" + specialization + '\'' +
                '}';
    }
}
