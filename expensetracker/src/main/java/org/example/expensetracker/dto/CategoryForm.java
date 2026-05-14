package org.example.expensetracker.dto;

import org.example.expensetracker.entity.CategoryType;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class CategoryForm {


    private Long id;

    @NotBlank(message = "Id cannot be blank")
    @Size(max = 80, message = "Id cannot exceed 80 characters")
    private String name;

    @NotNull(message = "Category cannot be null")
    private CategoryType type;
}
