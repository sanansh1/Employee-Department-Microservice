package com.sandhya.employeeservice.service;

import com.sandhya.employeeservice.dto.APIResponseDto;
import com.sandhya.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeByEmail(String email);

    APIResponseDto getEmployeeById(Long id);
}
