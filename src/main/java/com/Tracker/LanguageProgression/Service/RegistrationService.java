package com.Tracker.LanguageProgression.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepository;

	public boolean registerUser(String userName, String password, String email) {

		if (userRepository.findByUserName(userName) == null) {
			User user = new User();
			
			user.setUserName(userName);
			user.setPassword(password);
			user.setEmail(email);

			userRepository.save(user);
			
			return true;
			
		} else {
			
			return false;
		}

	}
}
