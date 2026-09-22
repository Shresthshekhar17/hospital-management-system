package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
}