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

import com.hospital.management.entity.Prescription;
import com.hospital.management.service.PrescriptionService;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(
            @RequestBody Prescription prescription) {

        Prescription savedPrescription =
                prescriptionService.createPrescription(prescription);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedPrescription);
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {

        List<Prescription> prescriptions =
                prescriptionService.getAllPrescriptions();

        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(
            @PathVariable Long id) {

        Prescription prescription =
                prescriptionService.getPrescriptionById(id);

        return ResponseEntity.ok(prescription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(
            @PathVariable Long id,
            @RequestBody Prescription prescription) {

        Prescription updatedPrescription =
                prescriptionService.updatePrescription(id, prescription);

        return ResponseEntity.ok(updatedPrescription);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(
            @PathVariable Long id) {

        prescriptionService.deletePrescription(id);

        return ResponseEntity.noContent().build();
    }
}