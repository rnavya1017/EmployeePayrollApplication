package com.bridgelabz.EmployeePayrollApplication.service;

import com.bridgelabz.EmployeePayrollApplication.entity.Department;
import com.bridgelabz.EmployeePayrollApplication.entity.Employee;
import com.bridgelabz.EmployeePayrollApplication.exception.DepartmentNotFoundException;
import com.bridgelabz.EmployeePayrollApplication.exception.DuplicateDataException;
import com.bridgelabz.EmployeePayrollApplication.exception.EmployeeNotFoundException;
import com.bridgelabz.EmployeePayrollApplication.repository.DepartmentRepository;
import com.bridgelabz.EmployeePayrollApplication.repository.EmployeeRepository;
import com.bridgelabz.EmployeePayrollApplication.requestdto.EmployeeRequestDTO;
import com.bridgelabz.EmployeePayrollApplication.responsedto.EmployeeResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request) {
        if (employeeRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateDataException("Employee with email already exists");
        }
        if (employeeRepository.existsByPhone(request.getPhone())) {
            throw new DuplicateDataException("Employee with phone number already exists");
        }
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new DepartmentNotFoundException("Department not found with ID " + request.getDepartmentId()));

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);
        return convertToResponse(savedEmployee);
    }

    public List<EmployeeResponseDTO> getAllEmployees()
    {
        return employeeRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public EmployeeResponseDTO getEmployeeById(Long id)
    {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found with ID :"+id));
        return convertToResponse(employee);
    }

    @Transactional
    public EmployeeResponseDTO updateEmployee(Long id,EmployeeRequestDTO employeeRequestDTO)
    {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employeee not found with ID:"+id));
        Department department=departmentRepository.findById(employeeRequestDTO.getDepartmentId()).orElseThrow(()->new DepartmentNotFoundException("Departemnt not found"));

        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setPhone(employeeRequestDTO.getPhone());
        employee.setDepartment(department);
        Employee updatedEmployee=employeeRepository.save(employee);
        return convertToResponse(updatedEmployee);
    }

    @Transactional
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with ID: " + id
                        ));

        employeeRepository.delete(employee);
    }




    private EmployeeResponseDTO convertToResponse(Employee employee) {

        Long departmentId = null;
        String departmentName = null;

        if (employee.getDepartment() != null) {
            departmentId = employee.getDepartment().getId();
            departmentName = employee.getDepartment().getName();
        }

        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getPhone(),
                departmentId,
                departmentName
        );

    }
}
