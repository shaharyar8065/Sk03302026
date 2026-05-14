package org.example.expensetracker.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransactionForm {

    private Long id;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotNull(message = "Transaction date is required")
    @PastOrPresent (message = "Transaction date cannot be in the future")
    private LocalDate occurredOn;

    @Size(max = 255, message = "Note cannot exceed 255 characters")
    private String note;

    @NotNull(message = "Account is required")
    private Long accountId;

    @NotNull(message = "Category is required")
    private Long categoryId;
}
