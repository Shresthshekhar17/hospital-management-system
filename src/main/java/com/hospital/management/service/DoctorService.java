package com.hospital.management.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.Doctor;
import com.hospital.management.repository.DoctorRepository;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Doctor not found with id: " + id));
    }
    public Doctor updateDoctor(Long id, Doctor doctor) {

        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Doctor not found with id: " + id));

        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setGender(doctor.getGender());
        existingDoctor.setQualification(doctor.getQualification());
        existingDoctor.setExperience(doctor.getExperience());
        existingDoctor.setDepartment(doctor.getDepartment());

        return doctorRepository.save(existingDoctor);
    }
    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Doctor not found with id: " + id));

        doctorRepository.delete(doctor);
    }
}