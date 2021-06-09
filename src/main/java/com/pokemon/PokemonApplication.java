package com.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}
	
	

}
