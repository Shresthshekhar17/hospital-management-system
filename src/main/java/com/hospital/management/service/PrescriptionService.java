package com.hospital.management.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.Prescription;
import com.hospital.management.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription createPrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Prescription not found with id: " + id));
    }

    public Prescription updatePrescription(
            Long id, Prescription prescription) {

        Prescription existingPrescription =
                prescriptionRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException(
                                "Prescription not found with id: " + id));

        existingPrescription.setPrescriptionDate(
                prescription.getPrescriptionDate());

        existingPrescription.setInstructions(
                prescription.getInstructions());

        existingPrescription.setPatient(
                prescription.getPatient());

        existingPrescription.setDoctor(
                prescription.getDoctor());

        return prescriptionRepository.save(existingPrescription);
    }

    public void deletePrescription(Long id) {

        Prescription prescription =
                prescriptionRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException(
                                "Prescription not found with id: " + id));

        prescriptionRepository.delete(prescription);
    }
}
