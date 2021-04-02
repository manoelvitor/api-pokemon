package com.pokemon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;

@Service
public class PokemonService implements ServiceInterface<Pokemon> {
	
	@Autowired
	PokemonRepository repository;
	
	@Override
	public Pokemon create(Pokemon obj) {
		repository.save(obj);
		return obj;
	}
	

	@Override
	public Pokemon findById(Long id) {
		Optional<Pokemon> _pokemon = repository.findById(id);
		return _pokemon.orElse(null);
	}

	@Override
	public List<Pokemon> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Pokemon obj) {
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
