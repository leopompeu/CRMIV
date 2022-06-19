package com.crmiv.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.crmiv.models.Consultores;
import com.crmiv.repository.ConsultoresRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private ConsultoresRepository cr;	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Consultores consultores = cr.findByLogin(email);
		if(consultores == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return consultores;
	}

}
