package org.example.services;

public class SmsNotification implements NotificationService {
    @Override
    public void notify(String recipient, String message) {
        System.out.println("SMS TO  : " + recipient);
        System.out.println("MESSAGE : " + message);
        System.out.println("STATUS  : SMS sent successfully");
    }
}
