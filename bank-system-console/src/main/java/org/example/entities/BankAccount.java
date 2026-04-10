package org.example.entities;

import java.math.BigDecimal;

    public abstract class BankAccount {
    private long id;
    private String accountNumber;
    private BigDecimal balance;
    private boolean active;


    public BankAccount(){}

    public BankAccount(String accountNumber, BigDecimal initialBalance) {
        if(initialBalance.compareTo(BigDecimal.ZERO) < 0 ) {
            throw new RuntimeException("Initial Balance has to be greater than or equal to zero");
        }
        this.id = 0;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.active = true;

    }

    public BankAccount(long id, String accountNumber, BigDecimal balance, boolean isActive) {
        if (balance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Initial Balance has to be greater than or equal to zero");
        }
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.active = isActive;
    }
    public abstract void applyMonthlyFee();

    public void deposit(BigDecimal amount) {
       if(amount.compareTo(BigDecimal.ZERO) < 0) {
           throw new RuntimeException("Amount passed is less than zero");
       }
       this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) >=0 ){
            throw new RuntimeException("Amount passed is less then zero");
        }
        if(balance.compareTo(amount) <=0 ) {
            throw new RuntimeException("Balance must be greater than zero");
        }
        this.balance.subtract(amount);

    }


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