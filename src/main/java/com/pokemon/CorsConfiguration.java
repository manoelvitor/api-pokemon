package com.pokemon;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {
	

	@Override
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
	
	/*
	
	   public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }
	
	/* public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins("http://api-pokemon-fatec.herokuapp.com/");
		}
	
	
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("http://localhost:8080/elementos").allowedOrigins("http://localhost:8080")
		.allowedMethods(
				"GET", "POST", "PUT","DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	}
	
	 
	 */
	

}
