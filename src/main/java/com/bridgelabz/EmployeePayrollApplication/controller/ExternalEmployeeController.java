package com.bridgelabz.EmployeePayrollApplication.controller;


import com.bridgelabz.EmployeePayrollApplication.responsedto.ExternalEmployeeDTO;
import com.bridgelabz.EmployeePayrollApplication.service.ExternalEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/external")
public class ExternalEmployeeController {

    private final ExternalEmployeeService externalEmployeeService;

    public ExternalEmployeeController(
            ExternalEmployeeService externalEmployeeService) {

        this.externalEmployeeService =
                externalEmployeeService;
    }

    @GetMapping("/get/{id}/external-details")
    public ResponseEntity<ExternalEmployeeDTO> getExternalDetails(
            @PathVariable Long id) {

        ExternalEmployeeDTO response =
                externalEmployeeService
                        .getExternalEmployee(id);

        return ResponseEntity.ok(response);
    }
}