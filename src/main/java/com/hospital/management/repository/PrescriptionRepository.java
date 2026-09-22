package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.entity.Prescription;

public interface PrescriptionRepository
        extends JpaRepository<Prescription, Long> {
}
