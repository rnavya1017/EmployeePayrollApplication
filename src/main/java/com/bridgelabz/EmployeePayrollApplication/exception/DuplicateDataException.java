package com.bridgelabz.EmployeePayrollApplication.exception;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String message) {
        super(message);
    }
}
