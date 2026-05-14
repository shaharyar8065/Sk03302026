package org.example.ui;

import org.example.entities.Patient;
import org.example.errors.HospitalExceptions;
import org.example.services.HospitalService;

import java.util.List;
import java.util.Scanner;

public class PatientMenu {


    private final HospitalService service;
    private final Scanner         scanner;

    public PatientMenu(HospitalService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void show() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== PATIENT MENU =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Find Patient by ID");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Filter by Disease");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> registerPatient();
                case "2" -> viewAll();
                case "3" -> findById();
                case "4" -> update();
                case "5" -> delete();
                case "6" -> filterByDisease();
                case "0" -> running = false;
                default  -> System.out.println("Invalid option.");
            }
        }
    }

    private void registerPatient() {
        System.out.println("\n-- Register Patient --");
        System.out.print("ID      : "); String id      = scanner.nextLine().trim();
        System.out.print("Name    : "); String name    = scanner.nextLine().trim();
        System.out.print("Disease : "); String disease = scanner.nextLine().trim();

        try {
            service.registerPatient(new Patient(id, name, disease));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewAll() {
        List<Patient> list = service.getAllPatients();
        if (list.isEmpty()) { System.out.println("No patients found."); return; }
        System.out.println("\n-- All Patients --");
        list.forEach(System.out::println);
    }

    private void findById() {
        System.out.print("Patient ID: ");
        String id = scanner.nextLine().trim();
        try {
            System.out.println(service.getPatient(id));
        } catch (HospitalExceptions.PatientNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void update() {
        System.out.print("Patient ID to update: ");
        String id = scanner.nextLine().trim();
        try {
            Patient existing = service.getPatient(id);

            System.out.println("Current name    : " + existing.getName());
            System.out.print  ("New name        : "); String name = scanner.nextLine().trim();
            if (!name.isEmpty()) existing.setName(name);

            System.out.println("Current disease : " + existing.getDisease());
            System.out.print  ("New disease     : "); String disease = scanner.nextLine().trim();
            if (!disease.isEmpty()) existing.setDisease(disease);

            service.updatePatient(existing);
        } catch (HospitalExceptions.PatientNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void delete() {
        System.out.print("Patient ID to delete: ");
        String id = scanner.nextLine().trim();
        try {
            service.deletePatient(id);
        } catch (HospitalExceptions.PatientNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void filterByDisease() {
        System.out.print("Disease to filter by: ");
        String disease = scanner.nextLine().trim();

        // lambda passed as Predicate into service
        List<Patient> result = service.filterPatients(
                p -> p.getDisease().equalsIgnoreCase(disease)
        );

        if (result.isEmpty()) System.out.println("No patients found with: " + disease);
        else result.forEach(System.out::println);
    }
}
