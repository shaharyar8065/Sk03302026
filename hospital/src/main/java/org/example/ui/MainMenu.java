package org.example.ui;

import org.example.services.HospitalService;

import java.util.Scanner;

public class MainMenu {

    private final PatientMenu     patientMenu;
    private final DoctorMenu      doctorMenu;
    private final AppointmentMenu appointmentMenu;
    private final Scanner scanner;

    public MainMenu(HospitalService service, Scanner scanner) {
        this.scanner         = scanner;
        this.patientMenu     = new PatientMenu(service, scanner);
        this.doctorMenu      = new DoctorMenu(service, scanner);
        this.appointmentMenu = new AppointmentMenu(service, scanner);
    }

    public void start() {
        System.out.println("=======HOSPITAL MANAGEMENT SYSTEM ======");


        boolean running = true;
        while (running) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> patientMenu.show();
                case "2" -> doctorMenu.show();
                case "3" -> appointmentMenu.show();
                case "0" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
