package com.sandhya.employeeservice.mapper;

import com.sandhya.employeeservice.dto.EmployeeDto;
import com.sandhya.employeeservice.entity.Employee;

public class EmployeeMapper {

    public static Employee convertEmployeeDtoToEntity(EmployeeDto dto) {
        return new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getDepartmentCode(), dto.getOrganizationCode());
    }

    public static EmployeeDto convertEmployeeEntityToDto(Employee entity) {
        return new EmployeeDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmail(), entity.getDepartmentCode(), entity.getOrganizationCode());
    }
}
