package com.bancoby.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoby.backend.models.Acao;
import com.bancoby.backend.repositories.AcaoRepository;

@Service
public class AcaoService {
	
	@Autowired
	AcaoRepository acaoRepository;
	
	public Acao findById(Integer id) {
		Optional<Acao> obj = acaoRepository.findById(id);
		return obj.orElse(null);
	}

	public Acao create(Acao obj) {
		obj.setId(null);
		return acaoRepository.save(obj);
	}

	public List<Acao> findAll() {
		return acaoRepository.findAll();
	}
}
