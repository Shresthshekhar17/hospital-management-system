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

import com.hospital.management.entity.PrescriptionMedicine;
import com.hospital.management.service.PrescriptionMedicineService;

@RestController
@RequestMapping("/api/prescription-medicines")
public class PrescriptionMedicineController {

    private final PrescriptionMedicineService prescriptionMedicineService;

    public PrescriptionMedicineController(
            PrescriptionMedicineService prescriptionMedicineService) {
        this.prescriptionMedicineService =
                prescriptionMedicineService;
    }

    @PostMapping
    public ResponseEntity<PrescriptionMedicine> createMedicine(
            @RequestBody PrescriptionMedicine medicine) {

        PrescriptionMedicine savedMedicine =
                prescriptionMedicineService.createMedicine(medicine);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedMedicine);
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionMedicine>> getAllMedicines() {

        List<PrescriptionMedicine> medicines =
                prescriptionMedicineService.getAllMedicines();

        return ResponseEntity.ok(medicines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionMedicine> getMedicineById(
            @PathVariable Long id) {

        PrescriptionMedicine medicine =
                prescriptionMedicineService.getMedicineById(id);

        return ResponseEntity.ok(medicine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionMedicine> updateMedicine(
            @PathVariable Long id,
            @RequestBody PrescriptionMedicine medicine) {

        PrescriptionMedicine updatedMedicine =
                prescriptionMedicineService.updateMedicine(id, medicine);

        return ResponseEntity.ok(updatedMedicine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(
            @PathVariable Long id) {

        prescriptionMedicineService.deleteMedicine(id);

        return ResponseEntity.noContent().build();
    }
}
