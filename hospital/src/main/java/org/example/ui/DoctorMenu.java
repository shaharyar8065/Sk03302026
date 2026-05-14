package org.example.ui;

import org.example.entities.Doctor;
import org.example.errors.HospitalExceptions;
import org.example.services.HospitalService;

import java.util.List;
import java.util.Scanner;

public class DoctorMenu {


    private final HospitalService service;
    private final Scanner scanner;

    public DoctorMenu(HospitalService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void show() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== DOCTOR MENU =====");
            System.out.println("1. Register Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Find Doctor by ID");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> registerDoctor();
                case "2" -> viewAll();
                case "3" -> findById();
                case "4" -> update();
                case "5" -> delete();
                case "0" -> running = false;
                default  -> System.out.println("Invalid option.");
            }
        }
    }

    private void registerDoctor() {
        System.out.println("\n-- Register Doctor --");
        System.out.print("ID             : "); String id   = scanner.nextLine().trim();
        System.out.print("Name           : "); String name = scanner.nextLine().trim();
        System.out.print("Specialization : "); String spec = scanner.nextLine().trim();

        try {
            service.registerDoctor(new Doctor(id, name, spec));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewAll() {
        List<Doctor> list = service.getAllDoctors();
        if (list.isEmpty()) { System.out.println("No doctors found."); return; }
        System.out.println("\n-- All Doctors --");
        list.forEach(System.out::println);
    }

    private void findById() {
        System.out.print("Doctor ID: ");
        String id = scanner.nextLine().trim();
        try {
            System.out.println(service.getDoctor(id));
        } catch (HospitalExceptions.DoctorNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void update() {
        System.out.print("Doctor ID to update: ");
        String id = scanner.nextLine().trim();
        try {
            Doctor existing = service.getDoctor(id);

            System.out.println("Current name           : " + existing.getName());
            System.out.print  ("New name               : "); String name = scanner.nextLine().trim();
            if (!name.isEmpty()) existing.setName(name);

            System.out.println("Current specialization : " + existing.getSpecialization());
            System.out.print  ("New specialization     : "); String spec = scanner.nextLine().trim();
            if (!spec.isEmpty()) existing.setSpecialization(spec);

            service.updateDoctor(existing);
        } catch (HospitalExceptions.DoctorNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void delete() {
        System.out.print("Doctor ID to delete: ");
        String id = scanner.nextLine().trim();
        try {
            service.deleteDoctor(id);
        } catch (HospitalExceptions.DoctorNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
