package com.hospital.management.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.MedicalRecord;
import com.hospital.management.repository.MedicalRecordRepository;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }
    public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }
    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Medical record not found with id: " + id));
    }
    public MedicalRecord updateMedicalRecord(Long id, MedicalRecord medicalRecord) {

        MedicalRecord existingRecord = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Medical record not found with id: " + id));

        existingRecord.setRecordDate(medicalRecord.getRecordDate());
        existingRecord.setDiagnosis(medicalRecord.getDiagnosis());
        existingRecord.setSymptoms(medicalRecord.getSymptoms());
        existingRecord.setTreatment(medicalRecord.getTreatment());
        existingRecord.setNotes(medicalRecord.getNotes());
        existingRecord.setPatient(medicalRecord.getPatient());
        existingRecord.setDoctor(medicalRecord.getDoctor());

        return medicalRecordRepository.save(existingRecord);
    }
    public void deleteMedicalRecord(Long id) {

        MedicalRecord medicalRecord = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Medical record not found with id: " + id));

        medicalRecordRepository.delete(medicalRecord);
    }
}
