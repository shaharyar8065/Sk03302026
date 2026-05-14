package org.example.entities;

import org.example.contracts.Billable;
import java.math.BigDecimal;
import java.util.Objects;

public class Appointment implements Billable {

    private String  id;
    private Patient patient;
    private Doctor  doctor;
    private String  date;

    public Appointment(String id, Patient patient, Doctor doctor, String date) {
        this.id      = id;
        this.patient = patient;
        this.doctor  = doctor;
        this.date    = date;
    }

    @Override
    public BigDecimal calculateBill() {
        return new BigDecimal("499.99");
    }

    @Override
    public void printBill() {
        System.out.println("======= BILL =======");
        System.out.println("Appointment : " + id);
        System.out.println("Patient     : " + patient.getName());
        System.out.println("Doctor      : Dr. " + doctor.getName());
        System.out.println("Date        : " + date);
        System.out.println("Total Bill  : $" + calculateBill());
        System.out.println("====================");
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", date='" + date + '\'' +
                '}';
    }
}
