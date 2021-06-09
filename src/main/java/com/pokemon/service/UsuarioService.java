package com.pokemon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pokemon.model.Usuario;
import com.pokemon.repository.UsuarioRepository;

@Service
public class UsuarioService implements ServiceInterface<Usuario> {
	
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;

	@Override
	public Usuario create(Usuario obj) {
		obj.setSenha(passwordEnconder.encode(obj.getSenha()));
		repository.save(obj);
		return obj;
	}
	

	@Override
	public Usuario findById(Long id) {
		Optional<Usuario> _usuario = repository.findById(id);
		return _usuario.orElse(null);
	}

	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Usuario obj) {
		if(repository.existsById(obj.getId())) {
			repository.save(obj);
		return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
		return false;
	}
	

	
	
}
