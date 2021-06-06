package com.pokemon.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import com.pokemon.dto.CredenciaisDTO;
import com.pokemon.model.Treinador;
import com.pokemon.repository.TreinadorRepository;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private AuthenticationManager authenticationManager;
	private JWTUtil jwtUtil;
	private TreinadorRepository treinaRepo;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil,
			TreinadorRepository treinaRepo) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.treinaRepo = treinaRepo;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			CredenciaisDTO creds = new ObjectMapper().readValue(request.getInputStream(), CredenciaisDTO.class);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getLogin(),
					creds.getSenha(), new ArrayList<>());
			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String username = ((UserDetailsImpl) authResult.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		response.addHeader("Authentication", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		
		Treinador treinador = treinaRepo.findByLogin(username);
		treinador.setSenha(null);
		 Gson gson = new Gson();
		 String cliStr = gson.toJson(treinador);
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/json");
		 response.setCharacterEncoding("UTF-8");
		 out.print(cliStr);
		 out.flush(); 
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws java.io.IOException, javax.servlet.ServletException {
		response.setStatus(401);
		response.setContentType("application/json");
		response.getWriter().append(json());
	}


	private String json() {
		return "{\"timestamp\": " + new Date().getTime() + ", " + "\"status\": 401, "
				+ "\"error\": \"Não autorizado\", " + "\"message\": \"Email ou senha inválidos\", "
				+ "\"path\": \"/login\"}";
	}
}