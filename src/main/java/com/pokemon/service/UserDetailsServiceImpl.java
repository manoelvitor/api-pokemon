package com.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pokemon.model.TipoPerfil;
import com.pokemon.model.Treinador;
import com.pokemon.repository.TreinadorRepository;
import com.pokemon.security.UserDetailsImpl;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private TreinadorRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Treinador _treinador = repo.findByLogin(username);
		if (_treinador == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(_treinador.getId(), _treinador.getLogin(), 
				_treinador.getSenha(), _treinador.getPerfis());
	}
	


}
