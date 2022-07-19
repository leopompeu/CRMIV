package com.crmiv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crmiv.models.Enderecos;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Integer>{
	
	Optional<Enderecos> findById(Integer id);
	
}
