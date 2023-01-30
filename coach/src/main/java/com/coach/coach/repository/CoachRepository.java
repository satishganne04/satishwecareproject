package com.coach.coach.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coach.coach.entity.Coach;

public interface CoachRepository extends JpaRepository<Coach, Long> {

	Optional<Coach> findById(Long id);
}
