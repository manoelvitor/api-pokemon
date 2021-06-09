package com.pokemon.config;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.pokemon.service.ImplementsUserDetailsService;
*/
//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {
/*
	@Autowired
	private ImplementsUserDetailsService userDetailService;
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
				/*auth.inMemoryAuthentication().withUser("vitor").password(passwordEncoder().encode("123")).authorities("ADMIN")
				.and().withUser("user").password(passwordEncoder().encode("123")).authorities("USER");*/
	/*}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin();
	}
*/

}
