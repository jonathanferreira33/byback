package com.bancoby.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancoby.backend.models.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

}
