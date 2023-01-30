package com.User.User.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.User.User.entity.Coach;
import com.User.User.entity.User;
@Service
public interface UserService {
	public void signup(User user);

	public User validateUser(Long id, String password);

	/* public List<Coach> getDataFromCoach(); */

	

}
