package com.sandhya.deparmentservice.service.impl;

import com.sandhya.deparmentservice.dto.DepartmentDto;
import com.sandhya.deparmentservice.entity.Department;
import com.sandhya.deparmentservice.exception.ResourceNotFoundException;
import com.sandhya.deparmentservice.mapper.DepartmentMapper;
import com.sandhya.deparmentservice.repository.DepartmentRepository;
import com.sandhya.deparmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    /**
     * @param dto
     * @return
     */
    @Override
    public DepartmentDto saveDepartment(DepartmentDto dto) {
        // Department dto to department
        Department savedDept = departmentRepository.save(DepartmentMapper.convertDepartmentDtoToEntity(dto));
        return DepartmentMapper.convertDepartmentEntityToDto(savedDept);
    }

    /**
     * @param code
     * @return
     */
    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        if (department == null) {
            throw new ResourceNotFoundException("Department", "code", code);
        }
        return DepartmentMapper.convertDepartmentEntityToDto(department);
    }
}
