package com.crmiv.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crmiv.models.Consultores;
import com.crmiv.repository.ConsultoresRepository;

@RestController
@RequestMapping("/api/consultor")
public class ConsultoresController {
	
	private final ConsultoresRepository cr;
	private final PasswordEncoder encoder;
	
	public ConsultoresController(
			ConsultoresRepository cr,
			PasswordEncoder encoder) {
		this.cr = cr;
		this.encoder = encoder;
	}

	
	@GetMapping("/listarTodos")
	public ResponseEntity<List<Consultores>> listarTodos(){
		return ResponseEntity.ok(cr.findAll());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Consultores> cadastrar(@RequestBody Consultores consultor){
		consultor.setSenha(encoder.encode(consultor.getSenha()));
		return ResponseEntity.ok(cr.save(consultor));
	}
	
	@GetMapping("/logar")
	public ResponseEntity<Boolean> logar(@RequestParam String login, @RequestParam String senha){
		
		Optional<Consultores> optConsultores = cr.findByLogin(login);
		if(optConsultores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		
		Consultores consultor = optConsultores.get();
		boolean valid = encoder.matches(senha, consultor.getSenha());
		
		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;	
		return ResponseEntity.status(status).body(valid);
	}

}
