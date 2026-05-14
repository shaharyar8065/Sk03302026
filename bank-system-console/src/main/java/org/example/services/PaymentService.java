package org.example.services;

import org.example.utils.AuditLogger;
import org.example.utils.TransactionValidator;

public class PaymentService {
    private final TransactionValidator transactionValidator;
    private final AuditLogger logger;

    public PaymentService(TransactionValidator validator, AuditLogger logger) {
        this.transactionValidator = validator;
        this.logger = logger;
    }
}
