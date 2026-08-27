package com.bridgelabz.EmployeePayrollApplication.controller;


import com.bridgelabz.EmployeePayrollApplication.responsedto.GreetingResponseDTO;
import com.bridgelabz.EmployeePayrollApplication.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<GreetingResponseDTO> getGreeting(
            @PathVariable String name) {

        return ResponseEntity.ok(
                greetingService.getGreeting(name)
        );
    }
}