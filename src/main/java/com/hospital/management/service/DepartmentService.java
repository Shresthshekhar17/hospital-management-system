package com.hospital.management.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.Department;
import com.hospital.management.repository.DepartmentRepository;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Create department
    public Department createDepartment(Department department) {

        return departmentRepository.save(department);
    }

    // Get all departments
    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    // Get department by ID
    public Department getDepartmentById(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Department not found with id: " + id));
    }

    // Delete department
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Department not found with id: " + id));

        departmentRepository.delete(department);
    }
 // Update department
    public Department updateDepartment(Long id, Department department) {

        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Department not found with id: " + id));

        existingDepartment.setName(department.getName());
        existingDepartment.setDescription(department.getDescription());

        return departmentRepository.save(existingDepartment);
    }
}
