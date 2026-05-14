package org.example;

import org.example.config.DBUtil;
import org.example.dao.impl.AppointmentDAOImpl;
import org.example.dao.impl.DoctorDAOImpl;
import org.example.dao.impl.PatientDAOImpl;
import org.example.repository.HospitalRepository;
import org.example.services.EmailNotification;
import org.example.services.HospitalService;
import org.example.ui.MainMenu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1. test DB connection
        try {
            DBUtil.getConnection();
            System.out.println("Database connected.");
        } catch (Exception e) {
            System.out.println("Connection failed: " + e.getMessage());
            return;
        }

        // 2. wire up layers
        HospitalRepository repository = new HospitalRepository(
                new PatientDAOImpl(),
                new DoctorDAOImpl(),
                new AppointmentDAOImpl()
        );

        HospitalService service = new HospitalService(
                repository,
                new EmailNotification()
        );

        // 3. Scanner  shared across all menus
        Scanner scanner  = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(service, scanner);
        mainMenu.start();

        scanner.close();
    }
}