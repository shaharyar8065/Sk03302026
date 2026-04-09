package org.example;

import org.example.entities.BankAccount;
import org.example.entities.CheckingsAccount;
import org.example.entities.SavingsAccount;

import java.math.BigDecimal;
import java.util.List;

public class Main{
    public static void main(String[]args){
        List<BankAccount> listofAccounts = List.of(
                new SavingsAccount("dsbh23-3hdx",new BigDecimal("450.00"), new BigDecimal("4.5")),
                new SavingsAccount("vgdhs-dsvchx",new BigDecimal("1000.00"),new BigDecimal("6.1")),
                new CheckingsAccount("dhch2s-514kx",new BigDecimal("1600.00"), new BigDecimal("10.00"))
        );

        System.out.println(listofAccounts.get(0).equals(listofAccounts.get(0)));
    }
}


