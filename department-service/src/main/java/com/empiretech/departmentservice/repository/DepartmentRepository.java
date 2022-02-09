package com.empiretech.departmentservice.repository;

import com.empiretech.departmentservice.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentId(Long id);
    
}
