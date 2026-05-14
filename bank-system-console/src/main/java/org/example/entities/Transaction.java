package org.example.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private long id;
    private long fromAccountId;
    private long toAccount;
    private BigDecimal amount;
    private String type;
    private LocalDateTime createdAT;

    public Transaction(){}

    public Transaction(long fromAccountId, long toAccount, BigDecimal amount, String type){
        this.fromAccountId = fromAccountId;
        this.toAccount = toAccount;
        this.amount = amount;
        this.type = type;
        id = 0;
        createdAT = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public long getToAccount() {
        return toAccount;
    }

    public void setToAccount(long toAccount) {
        this.toAccount = toAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAT = createdAT;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Transaction that)) return false;
        return getId() == that.getId() && getFromAccountId() == that.getFromAccountId() && getToAccount() == that.getToAccount() && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getType(), that.getType()) && Objects.equals(getCreatedAT(), that.getCreatedAT());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFromAccountId(), getToAccount(), getAmount(), getType(), getCreatedAT());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", fromAccountId=" + fromAccountId +
                ", toAccount=" + toAccount +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", createdAT=" + createdAT +
                '}';
    }
}
