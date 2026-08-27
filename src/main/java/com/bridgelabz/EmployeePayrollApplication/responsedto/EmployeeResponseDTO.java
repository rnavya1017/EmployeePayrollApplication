package com.bridgelabz.EmployeePayrollApplication.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Long departmentId;
    private String departmentName;
}
