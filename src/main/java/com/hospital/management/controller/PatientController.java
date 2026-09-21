package com.hospital.management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.management.dto.PatientRequest;
import com.hospital.management.dto.PatientResponse;
import com.hospital.management.service.PatientService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/status")
    public String getPatientModuleStatus() {
        return patientService.getPatientModuleStatus();
    }

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(
            @Valid @RequestBody PatientRequest request) {

        PatientResponse response = patientService.createPatient(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Get all patients
    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {

        List<PatientResponse> patients = patientService.getAllPatients();

        return ResponseEntity.ok(patients);
    }

    // Get patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(
            @PathVariable Long id) {

        PatientResponse response = patientService.getPatientById(id);

        return ResponseEntity.ok(response);
    }
 // Update patient
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(
            @PathVariable Long id,
            @Valid @RequestBody PatientRequest request) {

        PatientResponse response = patientService.updatePatient(id, request);

        return ResponseEntity.ok(response);
    }
 // Delete patient
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {

        patientService.deletePatient(id);

        return ResponseEntity.noContent().build();
    }
}