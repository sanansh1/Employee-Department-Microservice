package com.sandhya.employeeservice.controller;

import com.sandhya.employeeservice.dto.APIResponseDto;
import com.sandhya.employeeservice.dto.EmployeeDto;
import com.sandhya.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long id) {
        APIResponseDto APIResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(APIResponseDto, HttpStatus.OK);
    }
}
