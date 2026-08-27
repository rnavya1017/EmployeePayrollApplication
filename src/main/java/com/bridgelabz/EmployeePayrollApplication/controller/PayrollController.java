package com.bridgelabz.EmployeePayrollApplication.controller;


import com.bridgelabz.EmployeePayrollApplication.requestdto.PayrollRequestDTO;
import com.bridgelabz.EmployeePayrollApplication.responsedto.PayrollResponseDTO;
import com.bridgelabz.EmployeePayrollApplication.service.PayrollService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping("/create/{id}/payroll")
    public ResponseEntity<PayrollResponseDTO> createPayroll(
            @PathVariable Long id,
            @Valid @RequestBody PayrollRequestDTO request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        payrollService.createPayroll(id, request)
                );
    }

    @GetMapping("/get/{id}/payroll")
    public ResponseEntity<List<PayrollResponseDTO>> getPayroll(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                payrollService.getPayroll(id)
        );
    }
}