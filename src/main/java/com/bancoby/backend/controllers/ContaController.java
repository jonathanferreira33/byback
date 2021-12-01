package com.bancoby.backend.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bancoby.backend.models.Conta;
import com.bancoby.backend.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContaController {

	@Autowired
	private ContaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> findById(@PathVariable Integer id) {
		Conta obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Conta> update(@PathVariable Integer id, @RequestBody Conta obj) {
		Conta newObj = service.update(id, obj);
		return ResponseEntity.status(202).body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Conta> create(@RequestBody Conta obj ) {
		Conta newObj = this.service.create(obj);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}")
					.buildAndExpand(newObj.getId())
					.toUri();
		return ResponseEntity.created(uri).build();
	}
}
