package com.bridgelabz.EmployeePayrollApplication.service;


import com.bridgelabz.EmployeePayrollApplication.entity.Employee;
import com.bridgelabz.EmployeePayrollApplication.entity.Payroll;
import com.bridgelabz.EmployeePayrollApplication.exception.EmployeeNotFoundException;
import com.bridgelabz.EmployeePayrollApplication.exception.PayrollNotFoundException;
import com.bridgelabz.EmployeePayrollApplication.repository.EmployeeRepository;
import com.bridgelabz.EmployeePayrollApplication.repository.PayrollRepository;
import com.bridgelabz.EmployeePayrollApplication.requestdto.PayrollRequestDTO;
import com.bridgelabz.EmployeePayrollApplication.responsedto.PayrollResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayrollService {

    private final EmployeeRepository employeeRepository;
    private final PayrollRepository payrollRepository;

    public PayrollService(EmployeeRepository employeeRepository,
                          PayrollRepository payrollRepository) {

        this.employeeRepository = employeeRepository;
        this.payrollRepository = payrollRepository;
    }

    @Transactional
    public PayrollResponseDTO createPayroll(
            Long employeeId,
            PayrollRequestDTO request) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with ID: "
                                        + employeeId
                        ));

        double basicSalary = request.getBasicSalary();
        double allowances = request.getAllowances() == null
                ? 0
                : request.getAllowances();

        double deductions = request.getDeductions() == null
                ? 0
                : request.getDeductions();

        double netSalary =
                basicSalary + allowances - deductions;

        Payroll payroll = new Payroll();

        payroll.setBasicSalary(basicSalary);
        payroll.setAllowances(allowances);
        payroll.setDeductions(deductions);
        payroll.setNetSalary(netSalary);
        payroll.setPayrollDate(LocalDate.now());
        payroll.setEmployee(employee);

        Payroll savedPayroll =
                payrollRepository.save(payroll);

        return convertToResponse(savedPayroll);
    }

    public List<PayrollResponseDTO> getPayroll(
            Long employeeId) {

        if (!employeeRepository.existsById(employeeId)) {
            throw new EmployeeNotFoundException(
                    "Employee not found with ID: " + employeeId
            );
        }

        List<Payroll> payrolls =
                payrollRepository.findByEmployeeId(employeeId);

        if (payrolls.isEmpty()) {
            throw new PayrollNotFoundException(
                    "No payroll records found"
            );
        }

        return payrolls.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    private PayrollResponseDTO convertToResponse(
            Payroll payroll) {

        return new PayrollResponseDTO(
                payroll.getId(),
                payroll.getEmployee().getId(),
                payroll.getBasicSalary(),
                payroll.getAllowances(),
                payroll.getDeductions(),
                payroll.getNetSalary(),
                payroll.getPayrollDate()
        );
    }
}