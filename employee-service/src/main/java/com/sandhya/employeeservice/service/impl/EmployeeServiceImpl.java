package com.sandhya.employeeservice.service.impl;

import com.sandhya.employeeservice.dto.APIResponseDto;
import com.sandhya.employeeservice.dto.DepartmentDto;
import com.sandhya.employeeservice.dto.EmployeeDto;
import com.sandhya.employeeservice.dto.OrganizationDto;
import com.sandhya.employeeservice.entity.Employee;
import com.sandhya.employeeservice.exception.ResourceNotFoundException;
import com.sandhya.employeeservice.mapper.EmployeeMapper;
import com.sandhya.employeeservice.repository.EmployeeRepository;
import com.sandhya.employeeservice.service.APIClient;
import com.sandhya.employeeservice.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;
    private final APIClient apiClient;

    /**
     * @param employeeDto
     * @return
     */
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee savedEmp = employeeRepository.save(EmployeeMapper.convertEmployeeDtoToEntity(employeeDto));
        return EmployeeMapper.convertEmployeeEntityToDto(savedEmp);
    }

    /**
     * @param email
     * @return
     */
    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findEmployeeByEmail(email);
        return EmployeeMapper.convertEmployeeEntityToDto(employee);
    }

    /**
     * @param id
     * @return
     */
    //@CircuitBreaker(label = "${spring.application.name}")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultData")
    @Override
    public APIResponseDto getEmployeeById(Long id) {
        LOGGER.info("Inside getEmployeeById method");
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", String.valueOf(id)));
        /*RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/
        // Get department details for the employee
        WebClient webclient = WebClient.builder().build();
        DepartmentDto departmentDto = webclient.get().uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();

        // Get organization details for the employee
        OrganizationDto organizationDto = webclient.get().uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode()).retrieve().bodyToMono(OrganizationDto.class).block();

        //DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = EmployeeMapper.convertEmployeeEntityToDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultData(Long id, Exception exception) {
        LOGGER.info("Inside getDefaultDepartment method");
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", String.valueOf(id)));
        /*RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();*/
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentDescription("Research & Development department");

        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setOrganizationCode("RD-001");
        organizationDto.setOrganizationDescription("R&D Training");
        organizationDto.setOrganizationName("Research & Development Training");
        //DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = EmployeeMapper.convertEmployeeEntityToDto(employee);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }
}
