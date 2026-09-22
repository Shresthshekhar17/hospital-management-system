package com.hospital.management.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.PrescriptionMedicine;
import com.hospital.management.repository.PrescriptionMedicineRepository;

@Service
public class PrescriptionMedicineService {

    private final PrescriptionMedicineRepository prescriptionMedicineRepository;

    public PrescriptionMedicineService(
            PrescriptionMedicineRepository prescriptionMedicineRepository) {
        this.prescriptionMedicineRepository =
                prescriptionMedicineRepository;
    }

    public PrescriptionMedicine createMedicine(
            PrescriptionMedicine medicine) {

        return prescriptionMedicineRepository.save(medicine);
    }

    public List<PrescriptionMedicine> getAllMedicines() {

        return prescriptionMedicineRepository.findAll();
    }

    public PrescriptionMedicine getMedicineById(Long id) {

        return prescriptionMedicineRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Prescription medicine not found with id: " + id));
    }

    public PrescriptionMedicine updateMedicine(
            Long id, PrescriptionMedicine medicine) {

        PrescriptionMedicine existingMedicine =
                prescriptionMedicineRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException(
                                "Prescription medicine not found with id: "
                                        + id));

        existingMedicine.setMedicineName(
                medicine.getMedicineName());

        existingMedicine.setDosage(
                medicine.getDosage());

        existingMedicine.setFrequency(
                medicine.getFrequency());

        existingMedicine.setDuration(
                medicine.getDuration());

        existingMedicine.setPrescription(
                medicine.getPrescription());

        return prescriptionMedicineRepository.save(existingMedicine);
    }

    public void deleteMedicine(Long id) {

        PrescriptionMedicine medicine =
                prescriptionMedicineRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException(
                                "Prescription medicine not found with id: "
                                        + id));

        prescriptionMedicineRepository.delete(medicine);
    }
}
