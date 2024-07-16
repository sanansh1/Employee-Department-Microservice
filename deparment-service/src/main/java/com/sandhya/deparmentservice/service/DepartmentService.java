package com.sandhya.deparmentservice.service;

import com.sandhya.deparmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto dto);

    DepartmentDto getDepartmentByCode(String id);
}
