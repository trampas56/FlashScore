package com.example.matchApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
                http.authorizeHttpRequests(
                		(authz) -> authz
                		.requestMatchers("/**", "/add", "/save", "/showMatches", "/deleteMatch", "/showOdds", "/addOdd").permitAll()
                        .anyRequest().authenticated()
                		);  
                return http.build();
    }
	
	@ControllerAdvice
	public class GlobalExceptionHandler {
	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	    }
	}
}