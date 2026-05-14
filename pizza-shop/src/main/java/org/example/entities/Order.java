package org.example.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class Order {
    private long orderNumber;
    private LocalDateTime orderTimestamp;
    private Map<Pizza, Integer> orderMap;
    private BigDecimal total;

    public Order() {
    }

    public Order(
            long orderNumber,
            LocalDateTime orderTimestamp,
            Map<Pizza, Integer> orderMap){

        this.orderNumber = orderNumber;
        this.orderTimestamp = orderTimestamp;
        this.orderMap = orderMap;
        orderMap.forEach((Pizza piz, Integer quan) ->
                this.total
                        .add((piz.getPrice().multiply(BigDecimal.valueOf(quan)))));

    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(LocalDateTime orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }

    public Map<Pizza, Integer> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<Pizza, Integer> orderMap) {
        this.orderMap = orderMap;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal() {
        orderMap.forEach((Pizza piz, Integer quan) ->
                this.total
                        .add((piz.getPrice().multiply(BigDecimal.valueOf(quan)))));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getOrderNumber(), order.getOrderNumber()) && Objects.equals(getOrderTimestamp(),
                order.getOrderTimestamp()) && Objects.equals(getOrderMap(),
                order.getOrderMap()) && Objects.equals(getTotal(), order.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderNumber(), getOrderTimestamp(), getOrderMap(), getTotal());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderTimestamp=" + orderTimestamp +
                ", orderMap=" + orderMap +
                ", total=" + total +
                '}';
    }
}
