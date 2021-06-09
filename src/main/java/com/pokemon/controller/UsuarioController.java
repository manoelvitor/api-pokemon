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

import com.pokemon.model.Elemento;
import com.pokemon.model.Usuario;
import com.pokemon.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements ControllerInteface<Usuario> {
	
	@Autowired
	private UsuarioService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		Usuario _usuario = service.findById(id);
		if(_usuario != null) {
			return ResponseEntity.ok(_usuario);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PostMapping
	public ResponseEntity<Usuario> post(@RequestBody Usuario obj) {
		service.create(obj);
		return ResponseEntity.ok(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Usuario obj) {
		if(service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if(service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
