package com.crmiv.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.crmiv.data.DetalheConsultorData;
import com.crmiv.models.Consultores;
import com.crmiv.repository.ConsultoresRepository;

@Component
public class DetalheConsultorServiceImpl implements UserDetailsService {

	private final ConsultoresRepository cr;
	
	public DetalheConsultorServiceImpl(ConsultoresRepository cr) {
		this.cr = cr;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Consultores> consultor = cr.findByLogin(username);
		if (consultor.isEmpty()) {
			throw new UsernameNotFoundException("O campo usuário não pode estar em branco");
		}
		
		return new DetalheConsultorData(consultor);
	}

}
