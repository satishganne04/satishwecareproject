package com.User.User.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.User.User.entity.Appointment;
import com.User.User.repo.AppointmentRepository;
import com.User.User.service.AppointmentService;
import com.User.User.service.AppointmentServiceImpl;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("/appointments")
	public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
	    Appointment savedAppointment = appointmentService.saveappointment(appointment);
	    return ResponseEntity.ok(savedAppointment);
	}

	 @PutMapping("/appointments/{id}")
	    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
	        Optional<Appointment> appointment = appointmentService.updateAppointment(id, updatedAppointment);
	        if (appointment.isPresent()) {
	            return ResponseEntity.ok(appointment.get());
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @DeleteMapping("/appointments/{id}")
	    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
	        appointmentService.deleteAppointment(id);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	}
