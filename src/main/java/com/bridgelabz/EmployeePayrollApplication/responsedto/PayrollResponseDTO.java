package com.bridgelabz.EmployeePayrollApplication.responsedto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayrollResponseDTO {
    private Long id;
    private Long employeeId;
    private double basicSalary;
    private double allowances;
    private double deductions;
    private double netSalary;
    private LocalDate payrollDate;

}
