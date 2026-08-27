package com.bridgelabz.EmployeePayrollApplication.service;


import com.bridgelabz.EmployeePayrollApplication.entity.Address;
import com.bridgelabz.EmployeePayrollApplication.entity.Employee;
import com.bridgelabz.EmployeePayrollApplication.exception.AddressNotFoundException;
import com.bridgelabz.EmployeePayrollApplication.exception.EmployeeNotFoundException;
import com.bridgelabz.EmployeePayrollApplication.repository.AddressRepository;
import com.bridgelabz.EmployeePayrollApplication.repository.EmployeeRepository;
import com.bridgelabz.EmployeePayrollApplication.requestdto.AddressRequestDTO;
import com.bridgelabz.EmployeePayrollApplication.responsedto.AddressResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    public AddressService(EmployeeRepository employeeRepository,
                          AddressRepository addressRepository) {

        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public AddressResponseDTO addAddress(
            Long employeeId,
            AddressRequestDTO request) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with ID: " + employeeId
                        ));

        Address address = new Address();

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZipCode(request.getZipCode());
        address.setEmployee(employee);

        Address savedAddress =
                addressRepository.save(address);

        employee.setAddress(savedAddress);

        return convertToResponse(savedAddress);
    }

    public AddressResponseDTO getAddress(Long employeeId) {

        Address address = addressRepository
                .findByEmployeeId(employeeId)
                .orElseThrow(() ->
                        new AddressNotFoundException(
                                "Address not found for employee ID: "
                                        + employeeId
                        ));

        return convertToResponse(address);
    }

    @Transactional
    public AddressResponseDTO updateAddress(
            Long employeeId,
            AddressRequestDTO request) {

        Address address = addressRepository
                .findByEmployeeId(employeeId)
                .orElseThrow(() ->
                        new AddressNotFoundException(
                                "Address not found"
                        ));

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZipCode(request.getZipCode());

        return convertToResponse(
                addressRepository.save(address)
        );
    }

    private AddressResponseDTO convertToResponse(Address address) {

        return new AddressResponseDTO(
                address.getId(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipCode(),
                address.getEmployee().getId()
        );
    }
}