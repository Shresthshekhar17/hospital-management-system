package com.hospital.management.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hospital.management.dto.PatientRequest;
import com.hospital.management.dto.PatientResponse;
import com.hospital.management.entity.Patient;
import com.hospital.management.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Test method
    public String getPatientModuleStatus() {
        return "Patient module is working";
    }

    // Create a new patient
    public PatientResponse createPatient(PatientRequest request) {

        Patient patient = new Patient();

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setEmail(request.getEmail());
        patient.setPhone(request.getPhone());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setGender(request.getGender());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setAddress(request.getAddress());

        patient.setCreatedAt(LocalDateTime.now());
        patient.setUpdatedAt(LocalDateTime.now());

        Patient savedPatient = patientRepository.save(patient);

        PatientResponse response = new PatientResponse();

        response.setId(savedPatient.getId());
        response.setFirstName(savedPatient.getFirstName());
        response.setLastName(savedPatient.getLastName());
        response.setEmail(savedPatient.getEmail());
        response.setPhone(savedPatient.getPhone());
        response.setDateOfBirth(savedPatient.getDateOfBirth());
        response.setGender(savedPatient.getGender());
        response.setBloodGroup(savedPatient.getBloodGroup());
        response.setAddress(savedPatient.getAddress());
        response.setCreatedAt(savedPatient.getCreatedAt());
        response.setUpdatedAt(savedPatient.getUpdatedAt());

        return response;
    }

    // Get all patients
    public List<PatientResponse> getAllPatients() {

        List<Patient> patients = patientRepository.findAll();

        return patients.stream().map(patient -> {

            PatientResponse response = new PatientResponse();

            response.setId(patient.getId());
            response.setFirstName(patient.getFirstName());
            response.setLastName(patient.getLastName());
            response.setEmail(patient.getEmail());
            response.setPhone(patient.getPhone());
            response.setDateOfBirth(patient.getDateOfBirth());
            response.setGender(patient.getGender());
            response.setBloodGroup(patient.getBloodGroup());
            response.setAddress(patient.getAddress());
            response.setCreatedAt(patient.getCreatedAt());
            response.setUpdatedAt(patient.getUpdatedAt());

            return response;

        }).toList();
    }

    // Get patient by ID
    public PatientResponse getPatientById(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Patient not found with id: " + id));

        PatientResponse response = new PatientResponse();

        response.setId(patient.getId());
        response.setFirstName(patient.getFirstName());
        response.setLastName(patient.getLastName());
        response.setEmail(patient.getEmail());
        response.setPhone(patient.getPhone());
        response.setDateOfBirth(patient.getDateOfBirth());
        response.setGender(patient.getGender());
        response.setBloodGroup(patient.getBloodGroup());
        response.setAddress(patient.getAddress());
        response.setCreatedAt(patient.getCreatedAt());
        response.setUpdatedAt(patient.getUpdatedAt());

        return response;
    }

    // Update patient
    public PatientResponse updatePatient(Long id, PatientRequest request) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Patient not found with id: " + id));

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setEmail(request.getEmail());
        patient.setPhone(request.getPhone());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setGender(request.getGender());
        patient.setBloodGroup(request.getBloodGroup());
        patient.setAddress(request.getAddress());

        patient.setUpdatedAt(LocalDateTime.now());

        Patient updatedPatient = patientRepository.save(patient);

        PatientResponse response = new PatientResponse();

        response.setId(updatedPatient.getId());
        response.setFirstName(updatedPatient.getFirstName());
        response.setLastName(updatedPatient.getLastName());
        response.setEmail(updatedPatient.getEmail());
        response.setPhone(updatedPatient.getPhone());
        response.setDateOfBirth(updatedPatient.getDateOfBirth());
        response.setGender(updatedPatient.getGender());
        response.setBloodGroup(updatedPatient.getBloodGroup());
        response.setAddress(updatedPatient.getAddress());
        response.setCreatedAt(updatedPatient.getCreatedAt());
        response.setUpdatedAt(updatedPatient.getUpdatedAt());

        return response;
    }
 // Delete patient
    public void deletePatient(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Patient not found with id: " + id));

        patientRepository.delete(patient);
    }
}