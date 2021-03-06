package com.crmiv.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crmiv.models.Leeds;

@Repository
public interface LeedsRepository extends JpaRepository<Leeds, Integer> {
	
	Optional<Leeds> findById(Integer id);
	
}
