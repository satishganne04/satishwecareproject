package com.User.User.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.User.User.entity.Appointment;
@Service
public interface AppointmentService {

	Appointment saveappointment(Appointment appointment);

	Optional<Appointment> updateAppointment(Long id, Appointment updatedAppointment);

	void deleteAppointment(Long id);

}
