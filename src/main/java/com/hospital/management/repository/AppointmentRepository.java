package com.hospital.management.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.management.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	boolean existsByDoctorIdAndAppointmentDateAndAppointmentTime(
	        Long doctorId,
	        LocalDate appointmentDate,
	        LocalTime appointmentTime);

}
