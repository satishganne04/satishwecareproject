package com.User.User.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.User.User.entity.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{

}
