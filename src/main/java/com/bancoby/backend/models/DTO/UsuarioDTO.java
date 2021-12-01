package com.bancoby.backend.models.DTO;

import com.bancoby.backend.models.Conta;
import com.bancoby.backend.models.Usuario;

//@Entity
public class UsuarioDTO {
	
	private String nome;
	private Conta conta;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String nome, Conta conta) {
		super();
		this.nome = nome;
		this.conta = conta;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Usuario transformaParaDTO() {
		return new Usuario(nome, conta);
	}
	
	
	

}
