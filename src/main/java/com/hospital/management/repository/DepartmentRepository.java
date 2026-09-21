package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.entity.Department;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {

}
