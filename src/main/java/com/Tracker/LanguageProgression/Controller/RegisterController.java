package com.Tracker.LanguageProgression.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;

import lombok.Data;

@Controller
@Data
public class RegisterController {
    
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/register")
	public String register(){
		return "register";
	}
	
	@PostMapping("/register")
    public String registerUser(@RequestParam String userName, @RequestParam String password, @RequestParam String email) {
        User user = new User();
        
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        
        userRepository.save(user);
        return "redirect:/home";
    }

}
