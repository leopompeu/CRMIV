package com.crmiv.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.crmiv.data.DetalheConsultorData;
import com.crmiv.models.Consultores;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {
	
	public static final int TOKEN_EXPIRACAO = 7_200_000;
	public static final String TOKEN_SENHA = "add08b9e-2c6b-4263-82ba-b735322397e9";
	
	private final AuthenticationManager am;
	
	public JWTAutenticarFilter(AuthenticationManager am) {
		this.am = am;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
			HttpServletResponse response) throws AuthenticationException {

		try {
			Consultores consultor = new ObjectMapper()
					.readValue(request.getInputStream(), Consultores.class);
			
			return am.authenticate(new UsernamePasswordAuthenticationToken(
						consultor.getLogin(),
						consultor.getSenha(),
						new ArrayList<>()
					));
					
		} catch (IOException e) {
			throw new RuntimeException("Falha ao autenticar usuário", e);
		}	
	
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain, 
			Authentication authResult) throws IOException, ServletException {
		
		DetalheConsultorData consultorData = (DetalheConsultorData) authResult.getPrincipal();
		
		String token = JWT.create()
				.withSubject(consultorData.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
				.sign(Algorithm.HMAC512(TOKEN_SENHA));
		
		response.getWriter().write(token);
		response.getWriter().flush();
		
	}
		
}
