package com.bridgelabz.EmployeePayrollApplication.exception;

public class PayrollNotFoundException extends RuntimeException{
    public PayrollNotFoundException(String message) {
        super(message);
    }
}
