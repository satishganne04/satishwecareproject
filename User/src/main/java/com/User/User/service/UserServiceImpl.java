package com.User.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.User.User.coachFeignClient.CoachFeignClient;
import com.User.User.entity.Coach;
import com.User.User.entity.User;
import com.User.User.exception.InvalidInputException;
import com.User.User.repo.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	 private final UserRepository userRepository;

	    @Autowired
	    public UserServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	    
		/*
		 * @Autowired WebClient webClient;
		 * 
		 * @Autowired CoachFeignClient coachFeignClient;
		 */

	@Override
	public void signup(User user) {
		 if(!validateUser(user)) {
	            throw new InvalidInputException("Invalid user input");
	        }
	        // save user to the database
	        userRepository.save(user);
		
	}

	  private boolean validateUser(User user) {
        // Validate the user input
        if(user.getName().length()<3 || user.getName().length()>50) {
            return false;
        }
        if(user.getPassword().length()<5 || user.getPassword().length()>10) {
            return false;
        }
        if(user.getMobileNumber().length()!=10) {
            return false;
        }
        if(user.getEmail() == null || user.getEmail().isEmpty()) {
            return false;
        }
        if(user.getDateOfBirth() == null) {
            return false;
        }
        if(user.getGender() == null || user.getGender().isEmpty()) {
            return false;
        }
        if(user.getPincode().length()!=6) {
            return false;
        }
        if(user.getCity().length()<6 || user.getCity().length()>20) {
            return false;
        }
        if(user.getState().length()<6 || user.getState().length()>20) {
            return false;
        }
        if(user.getCountry().length()<6 || user.getCountry().length()>20) {
            return false;
        }
        return true;
    }

	@Override
	public User validateUser(Long id, String password) {
		 User user = userRepository.findById(id).orElse(null);
	        
	        // Check if the user exists and if the passwords match
	        if (user != null && user.getPassword().equals(password)) {
	            return user;
	        }
	        return null;
	    }

		/*
		 * @Override public List<Coach> getDataFromCoach() { // TODO Auto-generated
		 * method stub List<Coach> list= }
		 */

	
	}


