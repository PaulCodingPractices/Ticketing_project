package com.example.Ticketing_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TicketingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingProjectApplication.class, args);
	}

}
