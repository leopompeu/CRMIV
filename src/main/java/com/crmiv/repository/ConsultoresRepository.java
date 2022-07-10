package com.crmiv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crmiv.models.Consultores;

@Repository
@Transactional
public interface ConsultoresRepository extends JpaRepository<Consultores, Integer>{
	
	public Optional<Consultores> findByLogin(String login);
	
}
