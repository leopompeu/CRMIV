package com.crmiv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crmiv.models.Observacoes;

@Repository
public interface ObservacoesRepository extends JpaRepository<Observacoes, Integer> {

	Optional<Observacoes> findById(Integer id);
	
}
