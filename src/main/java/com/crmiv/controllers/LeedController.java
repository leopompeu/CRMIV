package com.crmiv.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crmiv.models.Leeds;
import com.crmiv.repository.LeedsRepository;

@RequestMapping("/api/leed")
@RestController
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

}
