package com.coach.coach.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coach.coach.entity.Coach;
import com.coach.coach.repository.CoachRepository;
@Service
public class CoachService {
	 @Autowired
	    private CoachRepository coachRepository;
	 
	
		

	 public boolean isValid(Long id, String password) {
	        Coach coach = coachRepository.findById(id).orElse(null);
	        if (coach != null && coach.getPassword().equals(password)) {
	            return true;
	        }
	        return false;
	    }
	 public Coach findById(Long id) {
	        return coachRepository.findById(id).orElse(null);
	    }
	public List<Coach> getAllData() {
		// TODO Auto-generated method stub
		return coachRepository.findAll();
	}
	 

}
	


