package com.pokemon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.model.Regiao;
import com.pokemon.repository.RegiaoRepository;



@Service
public class RegiaoService implements ServiceInterface<Regiao>{

	@Autowired
	RegiaoRepository repository;
	
	@Override
	public Regiao create(Regiao obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Regiao findById(Long id) {
		Optional<Regiao> _regiao = repository.findById(id);
		return _regiao.orElse(null);
	}

	@Override
	public List<Regiao> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(Regiao obj) {
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
