package com.Tracker.LanguageProgression.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	PasswordEncoder passwordEncoder;

	public boolean registerUser(String username, String password, String email) {

		if (userRepository.findByUsername(username) == null) {
			User user = new User();
			
			String encodedPassword = passwordEncoder.encode(password);
			
			user.setUsername(username);
			user.setPassword(encodedPassword);
			user.setEmail(email);

			userRepository.save(user);
			
			return true;
			
		} else {
			
			return false;
		}

	}
}
