package com.hospital.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hospital.management.entity.Appointment;

import com.hospital.management.service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @PostMapping
    public ResponseEntity<Appointment> createAppointment(
            @RequestBody Appointment appointment) {

        Appointment savedAppointment =
                appointmentService.createAppointment(appointment);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedAppointment);
    }
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {

        List<Appointment> appointments =
                appointmentService.getAllAppointments();

        return ResponseEntity.ok(appointments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(
            @PathVariable Long id) {

        Appointment appointment =
                appointmentService.getAppointmentById(id);

        return ResponseEntity.ok(appointment);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @RequestBody Appointment appointment) {

        Appointment updatedAppointment =
                appointmentService.updateAppointment(id, appointment);

        return ResponseEntity.ok(updatedAppointment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {

        appointmentService.deleteAppointment(id);

        return ResponseEntity.noContent().build();
    }
}
