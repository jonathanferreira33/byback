package com.bancoby.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoby.backend.models.Conta;
import com.bancoby.backend.repositories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	ContaRepository contaRepository;
	
	public Conta findById(Integer id) {
		Optional<Conta> obj = contaRepository.findById(id);
		return obj.orElse(null);
	}

	public Conta create(Conta obj) {
		obj.setId(null);
		return contaRepository.save(obj);
	}

	public Conta update(Integer id, Conta obj) {
		Conta newObj = findById(id);
		newObj.setAgencia(obj.getAgencia());
		newObj.setSaldo(obj.getSaldo());
		newObj.setTipo(obj.getTipo());
		
		return contaRepository.save(newObj);
	}
	
}
