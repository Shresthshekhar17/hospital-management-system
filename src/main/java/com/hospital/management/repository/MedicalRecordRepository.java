package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.entity.MedicalRecord;

public interface MedicalRecordRepository
        extends JpaRepository<MedicalRecord, Long> {

}