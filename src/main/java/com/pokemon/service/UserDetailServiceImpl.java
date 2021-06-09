package com.pokemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pokemon.model.TipoPerfil;
import com.pokemon.model.Usuario;
import com.pokemon.repository.UsuarioRepository;
import com.pokemon.security.UserDetailsImpl;

import org.springframework.security.core.GrantedAuthority;


import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByLogin(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(
				usuario.getId(),
				usuario.getLogin(),
				usuario.getSenha(),
				usuario.getPerfis());
	}
	

}