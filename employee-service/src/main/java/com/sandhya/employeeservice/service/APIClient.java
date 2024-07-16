package com.sandhya.employeeservice.service;


import com.sandhya.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    // Build get department rest api
    @GetMapping("api/departments/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable("departmentCode") String departmentCode);
}
