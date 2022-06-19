package com.crmiv.repository;

import org.springframework.data.repository.CrudRepository;
import com.crmiv.models.Consultores;

public interface ConsultoresRepository extends CrudRepository<Consultores, String>{
	
	Consultores findByLogin(String login);
	
}
