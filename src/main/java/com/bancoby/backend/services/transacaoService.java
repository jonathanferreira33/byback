package com.bancoby.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancoby.backend.models.Conta;
import com.bancoby.backend.models.Transacao;
import com.bancoby.backend.repositories.TransacaoRepository;
import com.bancoby.backend.services.exceptions.InsufficientFundsException;

@Service
public class transacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private ContaService contaService;

	public Transacao findById(Integer id) {
		Optional<Transacao> obj = transacaoRepository.findById(id);
		return obj.orElse(null);
	}

	public Transacao create(Transacao obj) {
		obj.setId(null);
		return transacaoRepository.save(obj);
	}

	public List<Transacao> findAll() {
		return transacaoRepository.findAll();
	}

	public void saque(Integer conta, Transacao transacao) {
		Conta contaDestino = this.contaService.findById(conta);

		Double saque = contaDestino.getSaldo() - transacao.getValor();
		contaDestino.setSaldo(saque);
		contaService.update(conta, contaDestino);

	}

	public void deposito(Integer conta, Transacao transacao) {
		Conta contaDestino = this.contaService.findById(conta);
		Double deposito = contaDestino.getSaldo() + transacao.getValor();
		contaDestino.setSaldo(deposito);
		contaService.update(conta, contaDestino);
	}
}
