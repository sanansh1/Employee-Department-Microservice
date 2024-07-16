package com.sandhya.deparmentservice.mapper;

import com.sandhya.deparmentservice.dto.DepartmentDto;
import com.sandhya.deparmentservice.entity.Department;

public class DepartmentMapper {

    public static Department convertDepartmentDtoToEntity(DepartmentDto dto) {
        return new Department(dto.getId(), dto.getDepartmentName(), dto.getDepartmentDescription(), dto.getDepartmentCode());
    }

    public static DepartmentDto convertDepartmentEntityToDto(Department entity) {
        return new DepartmentDto(entity.getId(), entity.getDepartmentName(), entity.getDepartmentDescription(), entity.getDepartmentCode());
    }
}
