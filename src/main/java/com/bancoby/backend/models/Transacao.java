package com.bancoby.backend.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer conta_origem;

	private Integer conta_destino;

	@Temporal(TemporalType.TIMESTAMP)
	private Date abertura = new java.sql.Date(System.currentTimeMillis());

	private Integer tipo;

	private Double valor;

	public Transacao() {
		super();
	}

	public Transacao(Integer conta_origem, Integer conta_destino, Date abertura, Integer tipo, Double valor) {
		super();
		this.conta_origem = conta_origem;
		this.conta_destino = conta_destino;
		this.abertura = abertura;
		this.tipo = tipo;
		this.valor = valor;
	}

	public Transacao(Integer conta_destino, Date abertura, Integer tipo, Double valor) {
		super();
		this.conta_destino = conta_destino;
		this.abertura = abertura;
		this.tipo = tipo;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getConta_origem() {
		return conta_origem;
	}

	public void setConta_origem(Integer conta_origem) {
		this.conta_origem = conta_origem;
	}

	public Integer getConta_destino() {
		return conta_destino;
	}

	public void setConta_destino(Integer conta_destino) {
		this.conta_destino = conta_destino;
	}

	public Date getAbertura() {
		return abertura;
	}

	public void setAbertura(Date abertura) {
		this.abertura = abertura;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		return Objects.equals(id, other.id);
	}

}
