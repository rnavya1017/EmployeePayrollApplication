package com.bridgelabz.EmployeePayrollApplication.requestdto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayrollRequestDTO{
    @NotNull(message = "Basic salary is required")
    @PositiveOrZero(message = "Basic salary cannot be negative")
    private Double basicSalary;

    @PositiveOrZero(message = "Allowances cannot be negative")
    private Double allowances;
    @PositiveOrZero(message = "Deductions cannot be negative")
    private Double deductions;
}
