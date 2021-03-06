package com.crmiv.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crmiv.models.Observacoes;
import com.crmiv.repository.ObservacoesRepository;

@RequestMapping("/observacoes")
@RestController
@CrossOrigin(origins = "*")
public class ObservacaoController {
	
	private final ObservacoesRepository or;

	public ObservacaoController(
			ObservacoesRepository or) {
		this.or = or;
	}

	@GetMapping("/listarObs/{id}")
	public Optional<Observacoes> listaObservacoes(@PathVariable(value="id") Integer id){
		return or.findById(id);
	}
	
	@PostMapping("/salvaObs")
	public Observacoes salvaObs (@RequestBody Observacoes obs) {
		return or.save(obs);
	}


}
