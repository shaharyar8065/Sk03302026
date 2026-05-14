package org.example.repositories;
import org.example.entities.Customer;
import org.example.entities.Order;
import org.example.entities.Pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PuesdoDatabase {
    private List<Pizza> pizzas;
    private List<Order> orders;
    private List<Customer> customers;


    public PuesdoDatabase() {
        this.pizzas = List.of(
                new Pizza("Cheese Pizza", new BigDecimal("9.99"), 'L'),
                new Pizza("Cheese Pizza", new BigDecimal("7.99"), 'M'),
                new Pizza("Cheese Pizza", new BigDecimal("5.99"), 'S'),
                new Pizza("Pepperoni Pizza", new BigDecimal("9.99"), 'L'),
                new Pizza("Pepperoni Pizza", new BigDecimal("7.99"), 'M'),
                new Pizza("Pepperoni Pizza", new BigDecimal("5.99"), 'S')
        );
        this.orders = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
