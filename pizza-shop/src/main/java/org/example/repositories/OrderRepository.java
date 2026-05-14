package org.example.repositories;

import org.example.entities.Order;

import java.util.List;

public class OrderRepository {
    private final PuesdoDatabase database;

    public OrderRepository(PuesdoDatabase database) {
        this.database = database;
    }

    public void save(Order order){
        database.getOrders().add(order);
    }

    public List<Order> getAllOrders(){
        return database.getOrders();
    }

    public void updateOrder(Order order){
        for (Order databaseOrder : database.getOrders()){
            if (databaseOrder.getOrderNumber() == order.getOrderNumber()){
                databaseOrder.setOrderMap(order.getOrderMap());
                databaseOrder.setTotal();
            }
        }
    }

}
