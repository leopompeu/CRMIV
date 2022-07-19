package com.crmiv.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crmiv.models.Leeds;
import com.crmiv.repository.LeedsRepository;

@RequestMapping("/leed")
@RestController
@CrossOrigin(origins = "*")
public class LeedController {
	
	private final LeedsRepository lr;

	public LeedController(
			LeedsRepository lr) {
		this.lr = lr;
	}

	@GetMapping("/listarTodos")
	public ResponseEntity<List<Leeds>> listarTodos(){
		return ResponseEntity.ok(lr.findAll());
	}
	
	@GetMapping("/listarLeed/{id}")
	public Optional<Leeds> listaLeed(@PathVariable(value="id") Integer id){
		return lr.findById(id);
	}
	
	@PostMapping("/salvaLeed")
	public Leeds salvaLeeds(@RequestBody Leeds leed) {
		return lr.save(leed);
	}

}
