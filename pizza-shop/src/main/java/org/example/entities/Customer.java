package org.example.entities;

import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;
    private long phone;
    private String address;
    private List<Order> orderlist;

    public Customer() {
    }

    public Customer(String name, long phone, String address, List<Order> orderlist) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.orderlist = orderlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List<Order> orderlist) {
        this.orderlist = orderlist;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) return false;
        return getPhone() == customer.getPhone() && Objects.equals(getName(), customer.getName()) && Objects.equals(getAddress(), customer.getAddress()) && Objects.equals(getOrderlist(), customer.getOrderlist());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone(), getAddress(), getOrderlist());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", orderlist=" + orderlist +
                '}';
    }
}
