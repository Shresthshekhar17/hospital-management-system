package com.hospital.management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.entity.MedicalRecord;
import com.hospital.management.service.MedicalRecordService;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }
    @PostMapping
    public ResponseEntity<MedicalRecord> createMedicalRecord(
            @RequestBody MedicalRecord medicalRecord) {

        MedicalRecord savedRecord =
                medicalRecordService.createMedicalRecord(medicalRecord);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedRecord);
    }
    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {

        List<MedicalRecord> records =
                medicalRecordService.getAllMedicalRecords();

        return ResponseEntity.ok(records);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> getMedicalRecordById(
            @PathVariable Long id) {

        MedicalRecord medicalRecord =
                medicalRecordService.getMedicalRecordById(id);

        return ResponseEntity.ok(medicalRecord);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(
            @PathVariable Long id,
            @RequestBody MedicalRecord medicalRecord) {

        MedicalRecord updatedRecord =
                medicalRecordService.updateMedicalRecord(id, medicalRecord);

        return ResponseEntity.ok(updatedRecord);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {

        medicalRecordService.deleteMedicalRecord(id);

        return ResponseEntity.noContent().build();
    }
}