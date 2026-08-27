package com.bridgelabz.EmployeePayrollApplication.repository;

import com.bridgelabz.EmployeePayrollApplication.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    boolean existsByName(String name);
}
