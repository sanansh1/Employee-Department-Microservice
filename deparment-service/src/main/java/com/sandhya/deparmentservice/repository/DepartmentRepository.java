package com.sandhya.deparmentservice.repository;

import com.sandhya.deparmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentCode(String departmentCode);
}
