package com.bancoby.backend.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bancoby.backend.models.Transacao;
import com.bancoby.backend.services.transacaoService;
import com.bancoby.backend.services.exceptions.InsufficientFundsException;

@RestController
@RequestMapping(value = "/transacoes")
@CrossOrigin("*")
public class TransacaoController {
	
	@Autowired
	private transacaoService service;
	
	@GetMapping
	public ResponseEntity<List<Transacao>> findAll() {
		List<Transacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Transacao> findById(@PathVariable Integer id) {
		Transacao obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@RequestMapping(value = "/transferencia")
	public ResponseEntity<Transacao> transferencia(@RequestBody Transacao obj) {
		Transacao newObj = this.service.create(obj);
		
		try {
			this.service.saque(newObj.getConta_origem(), newObj);
			this.service.deposito(newObj.getConta_destino(), newObj);
			
			URI uri = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(newObj.getId())
						.toUri();
			return ResponseEntity.created(uri).build();
			
			
		} catch (InsufficientFundsException e) {
			
			return ResponseEntity.status(412).body(null);
		}
		
		
	}
	
	@PostMapping
	@RequestMapping(value = "/saque")
	public ResponseEntity<Transacao> saque(@RequestBody Transacao obj) {
		Transacao newObj = this.service.create(obj);
		
		this.service.saque(newObj.getConta_destino(), newObj);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}")
					.buildAndExpand(newObj.getId())
					.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping
	@RequestMapping(value = "/deposito")
	public ResponseEntity<Transacao> deposito(@RequestBody Transacao obj) {
		Transacao newObj = this.service.create(obj);
		
		this.service.deposito(newObj.getConta_destino(), newObj);
		
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest().path("/{id}")
					.buildAndExpand(newObj.getId())
					.toUri();
		return ResponseEntity.created(uri).build();
	}
	

}
