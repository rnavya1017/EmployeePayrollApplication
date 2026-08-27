package com.bridgelabz.EmployeePayrollApplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private double basicSalary;
    private double allowances;
    private double deductions;
    @Column(nullable = false)
    private double netSalary;
    private LocalDate payrollDate;

    @ManyToOne
    @JoinColumn(name="employee_id",nullable = false)
    private Employee employee;

}
