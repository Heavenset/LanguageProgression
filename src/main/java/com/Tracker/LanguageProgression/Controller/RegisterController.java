package com.Tracker.LanguageProgression.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tracker.LanguageProgression.Repository.UserRepository;
import com.Tracker.LanguageProgression.Service.RegistrationService;

import lombok.Data;

@Controller
@Data
public class RegisterController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public String redirectRegisteredUser(@RequestParam String userName,
			@RequestParam String password, @RequestParam String email, @RequestParam String repeatedPasswordINPUT) {

		// Allowing to create profile and then redirect 
		// 		if the name does not exist in database. 
		if (registrationService.registerUser(userName, password, email) == true && password.equals(repeatedPasswordINPUT)) {
			System.out.println("User been created succesfully.");
			
			return "redirect:/home";
		}
			else {
				System.out.println("User already exist.");
				return "redirect:/register";
			}
	}
}
