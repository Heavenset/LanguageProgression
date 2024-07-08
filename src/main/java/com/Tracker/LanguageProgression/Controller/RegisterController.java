package com.Tracker.LanguageProgression.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String redirectRegisteredUser(@RequestParam String userName, @RequestParam String password,
			@RequestParam String email, @RequestParam String repeatedPassword, RedirectAttributes redirectAttributes) {

		
		// Checking for password equality (conformation of password upon register)
		if (!password.equals(repeatedPassword)) {
			redirectAttributes.addFlashAttribute("errorMessage", "Passwords have to match.");
			return "register";
		}

		// Allowing to create profile and then redirect 
		// 		if the name does not exist in database. 
		if (registrationService.registerUser(userName, password, email) == true) {
			System.out.println("User been created succesfully.");
			return "redirect:/home";
		}
		
			else {
				System.out.println("User already exist.");
				return "redirect:/register";
			}
	}
}
