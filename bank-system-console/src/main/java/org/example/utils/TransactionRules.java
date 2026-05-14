package org.example.utils;

import org.example.entities.Transaction;

import java.math.BigDecimal;
import java.util.function.Predicate;

public class TransactionRules {
    public static Predicate<Transaction> IS_LARGE = txn->
            txn.getAmount().compareTo(new BigDecimal("5000")) >0;
    public static Predicate<Transaction> IS_CREDIT = txn ->
            txn.getType().equalsIgnoreCase("credit");
    public static Predicate<Transaction> IS_DEBIT = txn ->
            txn.getType().equalsIgnoreCase("debit");
    public static Predicate<Transaction> IS_FLAGGED = txn ->
            IS_LARGE.and(IS_CREDIT).test(txn);
}
