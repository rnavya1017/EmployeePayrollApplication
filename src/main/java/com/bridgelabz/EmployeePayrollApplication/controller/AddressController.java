package com.bridgelabz.EmployeePayrollApplication.controller;


import com.bridgelabz.EmployeePayrollApplication.requestdto.AddressRequestDTO;
import com.bridgelabz.EmployeePayrollApplication.responsedto.AddressResponseDTO;
import com.bridgelabz.EmployeePayrollApplication.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add/{id}/address")
    public ResponseEntity<AddressResponseDTO> addAddress(
            @PathVariable Long id,
            @Valid @RequestBody AddressRequestDTO request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(addressService.addAddress(id, request));
    }

    @GetMapping("/get/{id}/address")
    public ResponseEntity<AddressResponseDTO> getAddress(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                addressService.getAddress(id)
        );
    }

    @PutMapping("/update/{id}/address")
    public ResponseEntity<AddressResponseDTO> updateAddress(
            @PathVariable Long id,
            @Valid @RequestBody AddressRequestDTO request) {

        return ResponseEntity.ok(
                addressService.updateAddress(id, request)
        );
    }
}
