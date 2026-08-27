package com.bridgelabz.EmployeePayrollApplication.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDTO {
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message="City is required")
    private String city;
    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zip code is required")
    @Pattern(regexp = "^[0-9]{6}$",
    message="Zip code must contain 6 digits")
    private String zipCode;

}
