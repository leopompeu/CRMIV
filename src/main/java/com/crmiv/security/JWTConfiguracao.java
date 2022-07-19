package com.crmiv.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.crmiv.service.DetalheConsultorServiceImpl;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class JWTConfiguracao extends WebSecurityConfigurerAdapter{
	
	
	private final DetalheConsultorServiceImpl consultorService;
	private final PasswordEncoder encoder;
	
	public JWTConfiguracao(DetalheConsultorServiceImpl consultorService,
			PasswordEncoder encoder) {
		this.consultorService = consultorService;
		this.encoder = encoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(consultorService).passwordEncoder(encoder);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable()
	        .authorizeRequests()
		        .antMatchers(HttpMethod.POST, "/login")
		        	.permitAll()
		        .antMatchers(HttpMethod.GET, "/consultor/logar")
		        	.permitAll()
		        .antMatchers(HttpMethod.POST, "/consultor/cadastrar")
		        	.permitAll()
		    .anyRequest().authenticated()
	        .and()
	        .addFilter(new JWTAutenticarFilter(authenticationManager()))
	        .addFilter(new JWTValidarFilter(authenticationManager()))
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);        
    }
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		source.registerCorsConfiguration("/**", corsConfiguration);
		return source;
	}
	
}
