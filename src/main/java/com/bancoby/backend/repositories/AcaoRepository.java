package com.bancoby.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancoby.backend.models.Acao;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Integer> {
	

}
