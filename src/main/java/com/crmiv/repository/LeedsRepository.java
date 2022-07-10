package com.crmiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crmiv.models.Leeds;

@Repository
public interface LeedsRepository extends JpaRepository<Leeds, Integer> {}
