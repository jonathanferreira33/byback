package com.bancoby.backend.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Agencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String endereco;

	@OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"agencia", "acoes"})
	private List<Conta> contas;

	public Agencia() {
		super();
	}

	public Agencia(String endereco, List<Conta> contas) {
		super();
		this.endereco = endereco;
		this.contas = contas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco, id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		return Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id);
	}

}
