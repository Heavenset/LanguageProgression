package com.Tracker.LanguageProgression.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Model.AuthenticationResponse;
import com.Tracker.LanguageProgression.Service.AuthenticationService;

import lombok.Data;

@RestController
@Data
public class AuthController {

	@Autowired
	private AuthenticationService authenticationService;



	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestParam User request){

		return ResponseEntity.ok(authenticationService.register(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestParam User request){

		return ResponseEntity.ok(authenticationService.authentication(request));
	}
}
