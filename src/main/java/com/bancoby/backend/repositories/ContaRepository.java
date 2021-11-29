package com.bancoby.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancoby.backend.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
