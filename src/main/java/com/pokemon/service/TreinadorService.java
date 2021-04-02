package com.pokemon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.model.Treinador;
import com.pokemon.repository.TreinadorRepository;

@Service
public class TreinadorService implements ServiceInterface<Treinador> {

	@Autowired
	TreinadorRepository repository;
	
	@Override
	public Treinador create(Treinador obj) {
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
		if(repository.existsById(obj.getId())){
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
