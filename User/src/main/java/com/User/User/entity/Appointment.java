package com.User.User.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date_of_appointment")
    private LocalDate dateOfAppointment;

    @Column(name = "slot")
    private String slot;

    @Column(name = "coachid")
    private Long coachId;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long appointmentId, Long userId, LocalDate dateOfAppointment, String slot, Long coachId) {
		super();
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.dateOfAppointment = dateOfAppointment;
		this.slot = slot;
		this.coachId = coachId;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public Long getCoachId() {
		return coachId;
	}

	public void setCoachId(Long coachId) {
		this.coachId = coachId;
	}




}
