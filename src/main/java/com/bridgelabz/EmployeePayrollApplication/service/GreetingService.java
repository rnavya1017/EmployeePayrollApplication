package com.bridgelabz.EmployeePayrollApplication.service;



import com.bridgelabz.EmployeePayrollApplication.responsedto.GreetingResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public GreetingResponseDTO getGreeting(String name) {

        return new GreetingResponseDTO(
                "Hello " + name + ", Welcome to Employee Payroll System!"
        );
    }
}