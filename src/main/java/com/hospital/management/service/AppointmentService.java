package com.hospital.management.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.hospital.management.entity.Appointment;
import com.hospital.management.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public Appointment createAppointment(Appointment appointment) {

        boolean alreadyBooked =
                appointmentRepository
                        .existsByDoctorIdAndAppointmentDateAndAppointmentTime(
                                appointment.getDoctor().getId(),
                                appointment.getAppointmentDate(),
                                appointment.getAppointmentTime());

        if (alreadyBooked) {
            throw new IllegalStateException(
                    "Doctor is already booked for this date and time");
        }

        return appointmentRepository.save(appointment);
    }
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Appointment not found with id: " + id));
    }
    public Appointment updateAppointment(Long id, Appointment appointment) {

        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Appointment not found with id: " + id));

        existingAppointment.setAppointmentDate(
                appointment.getAppointmentDate());

        existingAppointment.setAppointmentTime(
                appointment.getAppointmentTime());

        existingAppointment.setReason(
                appointment.getReason());

        existingAppointment.setStatus(
                appointment.getStatus());

        existingAppointment.setPatient(
                appointment.getPatient());

        existingAppointment.setDoctor(
                appointment.getDoctor());

        return appointmentRepository.save(existingAppointment);
    }
    public void deleteAppointment(Long id) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Appointment not found with id: " + id));

        appointmentRepository.delete(appointment);
    }
}
