package org.example.ui;

import org.example.entities.Appointment;
import org.example.entities.Doctor;
import org.example.entities.Patient;
import org.example.errors.HospitalExceptions;
import org.example.services.HospitalService;

import java.util.List;
import java.util.Scanner;

public class AppointmentMenu {

    private final HospitalService service;
    private final Scanner scanner;

    public AppointmentMenu(HospitalService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void show() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== APPOINTMENT MENU =====");
            System.out.println("1. Book Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Find Appointment by ID");
            System.out.println("4. Update Appointment Date");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. Print Bill");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> book();
                case "2" -> viewAll();
                case "3" -> findById();
                case "4" -> update();
                case "5" -> cancel();
                case "6" -> printBill();
                case "0" -> running = false;
                default  -> System.out.println("Invalid option.");
            }
        }
    }

    private void book() {
        System.out.println("\n-- Book Appointment --");
        System.out.print("Appointment ID   : "); String apptId    = scanner.nextLine().trim();
        System.out.print("Patient ID       : "); String patientId = scanner.nextLine().trim();
        System.out.print("Doctor ID        : "); String doctorId  = scanner.nextLine().trim();
        System.out.print("Date (YYYY-MM-DD): "); String date      = scanner.nextLine().trim();

        try {
            // fetch real objects so Appointment HAS full Patient and Doctor
            Patient patient = service.getPatient(patientId);
            Doctor doctor  = service.getDoctor(doctorId);

            service.bookAppointment(new Appointment(apptId, patient, doctor, date));
        } catch (HospitalExceptions.PatientNotFoundException |
                 HospitalExceptions.DoctorNotFoundException |
                 HospitalExceptions.AppointmentConflictException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewAll() {
        List<Appointment> list = service.getAllAppointments();
        if (list.isEmpty()) { System.out.println("No appointments found."); return; }
        System.out.println("\n-- All Appointments --");
        list.forEach(System.out::println);
    }

    private void findById() {
        System.out.print("Appointment ID: ");
        String id = scanner.nextLine().trim();
        try {
            System.out.println(service.getAppointment(id));
        } catch (HospitalExceptions.AppointmentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void update() {
        System.out.print("Appointment ID to update: ");
        String id = scanner.nextLine().trim();
        try {
            Appointment existing = service.getAppointment(id);

            System.out.println("Current date : " + existing.getDate());
            System.out.print  ("New date     : "); String date = scanner.nextLine().trim();
            if (!date.isEmpty()) existing.setDate(date);

            service.updateAppointment(existing);
        } catch (HospitalExceptions.AppointmentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void cancel() {
        System.out.print("Appointment ID to cancel: ");
        String id = scanner.nextLine().trim();
        try {
            service.cancelAppointment(id);
        } catch (HospitalExceptions.AppointmentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void printBill() {
        System.out.print("Appointment ID: ");
        String id = scanner.nextLine().trim();
        try {
            service.getAppointment(id).printBill();
        } catch (HospitalExceptions.AppointmentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
