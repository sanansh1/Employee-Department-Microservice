package com.sandhya.employeeservice.repository;

import com.sandhya.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByEmail(String email);
}
