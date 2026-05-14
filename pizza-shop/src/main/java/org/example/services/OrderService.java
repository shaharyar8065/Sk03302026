package org.example.services;

import org.example.repositories.OrderRepository;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void displayOrder(){
        System.out.println("Order Detail");
        orderRepository.getAllOrders().forEach(System.out::println);
    }

}

