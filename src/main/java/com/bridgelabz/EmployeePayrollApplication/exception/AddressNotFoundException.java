package com.bridgelabz.EmployeePayrollApplication.exception;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(String message) {
        super(message);
    }
}
