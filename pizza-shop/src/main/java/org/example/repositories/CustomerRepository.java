package org.example.repositories;

import org.example.entities.Customer;

import java.util.List;

public class CustomerRepository {
    private final PuesdoDatabase database;


    public CustomerRepository(PuesdoDatabase database){
        this.database = database;
    }

    public void save(Customer customer){
        database.getCustomers().add(customer);
    }

    public List<Customer> getAllCustomers(){
        return database.getCustomers();
    }

//
//    public void updateOrder(Order order){
//        for (Order databaseOrder : database.getOrders()){
//            if (databaseOrder.getOrderNumber() == order.getOrderNumber()){
//                databaseOrder.setOrderMap(order.getOrderMap());
//                databaseOrder.setTotal();
//            }
//        }
//    }

    public void updateCustomer(Customer customer){
        for (Customer databaseCustomer : database.getCustomers()){
            if (databaseCustomer.getName() == customer.getName()){
                databaseCustomer.setName(customer.getName());
                databaseCustomer.setAddress(customer.getAddress());
                databaseCustomer.setPhone(customer.getPhone());

            }
        }
    }



}
