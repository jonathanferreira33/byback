package com.bancoby.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoby.backend.models.Agencia;
import com.bancoby.backend.repositories.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	AgenciaRepository agenciaRepository;
	
	public Agencia findById(Integer id) {
		Optional<Agencia> obj = agenciaRepository.findById(id);
		return obj.orElse(null);
	}

	public Agencia create(Agencia obj) {
		obj.setId(null);
		return agenciaRepository.save(obj);
	}

	public List<Agencia> findAll() {
		return agenciaRepository.findAll();
	}
}
