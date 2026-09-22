package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.entity.PrescriptionMedicine;

public interface PrescriptionMedicineRepository
        extends JpaRepository<PrescriptionMedicine, Long> {
}