package com.bancoby.backend.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bancoby.backend.models.Acao;
import com.bancoby.backend.services.AcaoService;

@RestController
@RequestMapping(value = "/acoes")
@CrossOrigin("*")
public class AcaoController {

	@Autowired
	private AcaoService service;
	
	
	@PostMapping
	public ResponseEntity<Acao> create(@RequestBody Acao obj ) {
		Acao newObj = this.service.create(obj);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}")
					.buildAndExpand(newObj.getId())
					.toUri();
		return ResponseEntity.created(uri).build();
	}
}
