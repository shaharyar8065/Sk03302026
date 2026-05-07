package org.example.entities;

import java.math.BigDecimal;

    public class BankAccount {
    private long id;
    private String accountNumber;
    private BigDecimal balance;
    private String type;
    private boolean active;


    private BankAccount(){}

    private BankAccount(String accountNumber, BigDecimal initialBalance) {
        if(initialBalance.compareTo(BigDecimal.ZERO) < 0 ) {
            throw new RuntimeException("Initial Balance has to be greater than or equal to zero");
        }
        this.id = 0;
        this.accountNumber = accountNumber;
        this.type = "CHECKING";
        this.balance = initialBalance;
        this.active = true;

    }

    private BankAccount(long id, String accountNumber, BigDecimal balance, String type, boolean isActive) {
        if (balance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Initial Balance has to be greater than or equal to zero");
        }
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.active = isActive;
    }

    public static BankAccount newChecking(String num,BigDecimal amount){
        return new BankAccount(num, amount);
    }

    public static BankAccount newSaving(String num, BigDecimal amount) {
        return new BankAccount(0 ,num, amount, "SAVINGS", true);
    }

    public static BankAccount newBusiness(String num, BigDecimal amount) {
        return new BankAccount(0, num, amount, "BUSINESS", true);
    }

    public void deposit(BigDecimal amount) {
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
            balance.subtract(amount);
    }



  //  public abstract void applyMonthlyFee();

//    public void deposit(BigDecimal amount) {
//       if(amount.compareTo(BigDecimal.ZERO) < 0) {
//           throw new RuntimeException("Amount passed is less than zero");
//       }
//       this.balance.add(amount);
//    }
//
//    public void withdraw(BigDecimal amount){
//        if(amount.compareTo(BigDecimal.ZERO) >=0 ){
//            throw new RuntimeException("Amount passed is less then zero");
//        }
//        if(balance.compareTo(amount) <=0 ) {
//            throw new RuntimeException("Balance must be greater than zero");
//        }
//        this.balance.subtract(amount);
//
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", active=" + active +
                '}';
    }
}