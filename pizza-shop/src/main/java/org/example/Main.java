package org.example;

import org.example.config.DatabaseConfig;
import org.example.entities.Pizza;
import org.example.repositories.*;
import org.example.services.CustomerService;
import org.example.services.OrderService;
import org.example.services.PizzaService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        static void main() {
//
//        final PuesdoDatabase database = new PuesdoDatabase();
//        final PizzaRepository pizzaRepository = new PizzaRepository(database);
//        final CustomerRepository customerRepository = new CustomerRepository(database);
//        final OrderRepository orderRepository = new OrderRepository(database);
//        final PizzaService pizzaService = new PizzaService(pizzaRepository);
//        final CustomerService customerService = new CustomerService(customerRepository);
//        final OrderService orderService = new OrderService(orderRepository);
//
//
//        pizzaService.displayPizzas();
//        customerService.displayCustomer();
//        orderService.displayOrder();
//
//
        Connection connection = null;
        try {
            connection = DatabaseConfig.getInstance().getConn();
            System.out.println("DATABASE CONNECTION MADE!!!");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
;       JdbcPizzaRepository repository = new JdbcPizzaRepository(connection);
       repository.save(new Pizza("Cheese Pizza",new BigDecimal(9.99), 'L'));

       }
}
