package com.pokemon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pokemon.exception.AuthorizationException;
import com.pokemon.model.Treinador;
import com.pokemon.repository.TreinadorRepository;
import com.pokemon.security.JWTUtil;
import com.pokemon.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;




@Service
public class TreinadorService implements ServiceInterface<Treinador> {

	@Autowired
	TreinadorRepository repository;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	

	public static UserDetailsImpl authenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			return (UserDetailsImpl) auth.getPrincipal();
		}
		return null;
	}

	@Override
	public Treinador create(Treinador obj) {
		obj.setSenha(passwordEncoder.encode(obj.getSenha()));
		repository.save(obj);
		return obj;
	}

	@Override
	public Treinador findById(Long id) {
		Optional<Treinador> _treinador = repository.findById(id);
		return _treinador.orElse(null);
	}

	@Override
	public List<Treinador> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Treinador obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}



}
