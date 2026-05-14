package org.example.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Pizza {

    private long id;
    private String name;
    private BigDecimal price;
    private char size;


    public Pizza(){
        this.name = "Cheese Pizza";
        this.price = new BigDecimal("9.99");
        this.size =  'L';
    }

    public Pizza(String name, BigDecimal price, char size){
        this.name = name;
        this.price =  price;
        this.size = size;
    }

  // getters and setters


    public long getId() { return id;}

    public void setId(long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    // equals and hashcodes

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pizza pizza)) return false;
        return getId() == pizza.getId() && getSize() == pizza.getSize() && Objects.equals(getName(), pizza.getName()) && Objects.equals(getPrice(), pizza.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getSize());
    }


    // to string


    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
