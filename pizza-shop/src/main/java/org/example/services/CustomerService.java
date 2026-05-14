package org.example.services;

import org.example.repositories.CustomerRepository;


public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;

    }
    public void displayCustomer(){
        System.out.println("Welcome");
        customerRepository.getAllCustomers().forEach(System.out::println);
    }



}
