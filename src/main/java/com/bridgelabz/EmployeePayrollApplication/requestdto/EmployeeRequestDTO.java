package com.bridgelabz.EmployeePayrollApplication.requestdto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {
    @NotBlank(message = "Name cannot be blank")
    @Size(min=2,max=50,message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone cannot be blank")
    @Pattern(
            regexp = "^[6-9][0-9]{9}$",
            message = "Phone number must contain 10 digits"
    )
    private String phone;

    @NotNull(message = "Department ID is required")
    private Long departmentId;


}
