package com.Tracker.LanguageProgression.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(requests -> requests
	            .requestMatchers("/css/**").permitAll()
	            .anyRequest().authenticated()
	        )
				.formLogin(formLogin -> formLogin.loginPage("/login").permitAll())
					.httpBasic(Customizer.withDefaults());

		return http.build();
	}
}