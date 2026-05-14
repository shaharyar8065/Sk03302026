package org.example.services;

import org.example.repositories.PizzaRepository;

public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;

    }

    public void displayPizzas() {
        System.out.println("Pizza Shop");
        pizzaRepository.getAllPizzas().forEach(System.out::println);
    }

}
