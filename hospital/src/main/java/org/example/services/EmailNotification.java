package org.example.services;

public class EmailNotification implements NotificationService{

    @Override
    public void notify(String recipient, String message) {
        System.out.println("EMAIL TO : " + recipient);
        System.out.println("MESSAGE  : " + message);
        System.out.println("STATUS   : Email sent successfully");
    }
}
