package org.example.expensetracker.dto;

import lombok.*;
import org.example.expensetracker.entity.AccountType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Data

public class AccountForm {

    private Long id;

    @NotBlank(message = "Cannot be blank ")
    @Size(max = 100, message = "Name cannot exceed 100 character")
    private String name;

    @NotNull(message = "Type cannot be null")
    private AccountType type;

    @NotNull(message = "Balance should not be null")
    @DecimalMin("0.00")
    private BigDecimal openingBalance;
}
