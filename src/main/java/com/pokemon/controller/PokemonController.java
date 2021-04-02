package com.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.model.Pokemon;
import com.pokemon.service.PokemonService;

@RestController
@RequestMapping(value="/pokemons")
public class PokemonController implements ControllerInteface<Pokemon> {

	@Autowired
	PokemonService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Pokemon _pokemon = service.findById(id);
		if(_pokemon != null) {
			return ResponseEntity.ok(_pokemon);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PostMapping
	public ResponseEntity<Pokemon> post(@RequestBody Pokemon obj) {
		service.create(obj);
		return ResponseEntity.ok(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Pokemon obj) {
		if(service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Pokemon _pokemon = service.findById(id);
		if(_pokemon !=null) {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
