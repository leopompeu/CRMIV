package com.crmiv.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.crmiv.models.Consultores;

@SuppressWarnings("serial")
public class DetalheConsultorData implements UserDetails {

	private final Optional<Consultores> consultor;
	
	public DetalheConsultorData(Optional<Consultores> consultor) {
		this.consultor = consultor;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return consultor.orElse(new Consultores()).getSenha();
	}

	@Override
	public String getUsername() {
		return consultor.orElse(new Consultores()).getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
