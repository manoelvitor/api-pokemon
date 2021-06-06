package com.pokemon.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pokemon.service.S3Service;


@RestController
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	private S3Service service;

	@PostMapping
	public ResponseEntity<Void> uploadFile(@RequestParam(name = "file") MultipartFile file) {
		URI uri = service.upload(file);
		System.out.println();
		return ResponseEntity.created(uri).build();
		
	}

}
