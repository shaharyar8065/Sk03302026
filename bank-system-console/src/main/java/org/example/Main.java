package org.example;

import org.example.dtos.TransferRequest;
import org.example.entities.BankAccount;
import org.example.enums.Priority;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankAccount account = BankAccount
                .newChecking("JSKADNASSAJFN(*#@(*H9832", new BigDecimal("5000"));

        TransferRequest request = new TransferRequest
                .Builder("JSKADNASSAJFN(*#@(*H9832",
                "NUdsih79rh92fh92h",
                new BigDecimal("250")).priority(Priority.HIGH).build();
        TransferRequest request1 = new TransferRequest.Builder("JSKADNASSAJFN(*#@(*H9832",
                "NUdsih79rh92fh92h",
                new BigDecimal("250"))
                .note("Payback")
                .priority(Priority.LOW)
                .build();

        if(request.getAmount().compareTo(BigDecimal.ZERO) > 0 && request.getAmount().compareTo(request1.getAmount()) <= 0) {

        }
    }
}





//
//import org.example.entities.BankAccount;
//import org.example.entities.CheckingsAccount;
//import org.example.entities.SavingsAccount;
//import org.example.entities.Transferable;
//
//import javax.sql.rowset.serial.SQLOutputImpl;
//import java.math.BigDecimal;
//import java.util.List;
//
//public class Main{
//    public static void main(String[]args){
//        List<BankAccount> listofAccounts = List.of(
//                new SavingsAccount("dsbh23-3hdx",new BigDecimal("450.00"), new BigDecimal("4.5")),
//                new SavingsAccount("vgdhs-dsvchx",new BigDecimal("1000.00"),new BigDecimal("6.1")),
//                new CheckingsAccount("dhch2s-514kx",new BigDecimal("1600.00"), new BigDecimal("10.00"))
//        );
//
////        System.out.println(listofAccounts.get(0).equals(listofAccounts.get(0)));
//
//        Transferable[]transferables = new Transferable[10];
//                int count = 0;
//        for (BankAccount account : listofAccounts){
//            account.applyMonthlyFee();
//            if(account instanceof Transferable transferable){
//                transferables[count++] = transferable;
//            }
//        }
//
//        listofAccounts.forEach(System.out::println);
//        for (Transferable transferable : transferables){
//            System.out.println(transferable);
//        }
//    }
//}