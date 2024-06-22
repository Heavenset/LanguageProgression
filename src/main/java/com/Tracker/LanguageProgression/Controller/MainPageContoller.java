package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainPageContoller {
	
		@GetMapping("/")
		public String login() {
			return "main";
		
	}
}
