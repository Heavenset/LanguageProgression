package com.Tracker.LanguageProgression.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired PasswordEncoder passwordEncoder;

	public boolean registerUser(String userName, String password, String email) {


		
		if (userRepository.findByUserName(userName) == null) {
			User user = new User();
			
			String encodedPassword = passwordEncoder.encode(password);
			
			user.setUserName(userName);
			user.setPassword(encodedPassword);
			user.setEmail(email);

			userRepository.save(user);
			
			return true;
			
		} else {
			
			return false;
		}

	}
}
