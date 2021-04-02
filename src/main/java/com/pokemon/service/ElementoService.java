package com.pokemon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.model.Elemento;
import com.pokemon.repository.ElementoRepository;

@Service
public class ElementoService implements ServiceInterface<Elemento> {

	@Autowired
	ElementoRepository repository;
	
	@Override
	public Elemento create(Elemento obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Elemento findById(Long id) {
		Optional<Elemento> _elemento = repository.findById(id);
		return _elemento.orElse(null);
	}

	@Override
	public List<Elemento> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Elemento obj) {
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
			return true;
		}
		return false;
	}

}
