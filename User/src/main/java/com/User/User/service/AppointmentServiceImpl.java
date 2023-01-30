package com.User.User.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.User.User.entity.Appointment;
import com.User.User.repo.AppointmentRepository;
@Service
public class AppointmentServiceImpl implements AppointmentService {
	private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    
	@Override
	public Appointment saveappointment(Appointment appointment) {
		
		return appointmentRepository.save(appointment);
	}

	public Optional<Appointment> updateAppointment(Long id, Appointment updatedAppointment) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();
            appointment.setDateOfAppointment(updatedAppointment.getDateOfAppointment());
            appointment.setSlot(updatedAppointment.getSlot());
            appointment.setCoachId(updatedAppointment.getCoachId());
            Appointment savedAppointment = appointmentRepository.save(appointment);
            return Optional.of(savedAppointment);
        } else {
            return Optional.empty();
        }
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
	

	
}
