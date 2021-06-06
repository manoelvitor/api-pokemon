package com.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.exception.AuthorizationException;
import com.pokemon.model.Treinador;
import com.pokemon.service.TreinadorService;

@RestController
@RequestMapping(value = "/treinadores")
public class TreinadorController implements ControllerInteface<Treinador> {

	@Autowired
	TreinadorService service;

	@Override
	@GetMapping
	public ResponseEntity<List<Treinador>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		try {
			Treinador _treinador = service.findById(id);
			if (_treinador != null) {
				return ResponseEntity.ok(_treinador);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (AuthorizationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@Override
	@PostMapping
	public ResponseEntity<Treinador> post(@RequestBody Treinador obj) {
		service.create(obj);
		return ResponseEntity.ok(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Treinador obj) {
		if(service.update(obj)) {
			ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}")
	//@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if(service.delete(id)) 
			return ResponseEntity.ok().body("Deletado com sucesso!");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não é possivel deletar");
	}

}
