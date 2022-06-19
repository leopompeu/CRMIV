package com.crmiv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/consultor")
	public String consultor() {
		return "tela1";
	}

}
