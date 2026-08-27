package com.bridgelabz.EmployeePayrollApplication.responsedto;

public class GreetingResponseDTO {

    private String message;

    public GreetingResponseDTO() {
    }

    public GreetingResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
