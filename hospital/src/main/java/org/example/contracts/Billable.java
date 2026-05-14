package org.example.contracts;


import java.math.BigDecimal;

public interface Billable {

    BigDecimal calculateBill();

    void printBill();

}
