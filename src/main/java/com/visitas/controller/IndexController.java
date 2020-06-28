package com.visitas.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	
	@RequestMapping(value = "/ufps")
	public String loginUFPS(Model model,Principal principal ) {
		
		if(principal !=null) {
			return "redirect:/";
		}
		model.addAttribute("uni", "ufps");
		model.addAttribute("titulo", "Ufps Login");
		return "login";
	}
	
	@RequestMapping(value = "/login")
	public String log() {
		return "empresa";
	}
	
	@RequestMapping(value = "/unisimon")
	public String loginSimon(Model model,Principal principal ) {
		
		if(principal !=null) {
			return "redirect:/";
		}
		model.addAttribute("uni", "unisimon");
		model.addAttribute("titulo", "UNI Simon Login");
		return "login";
	}
	
	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("respuesta","usuario o clave incorrectos");
		return "index";
	}
	
	@RequestMapping(value = "/")
	public String index2(Model model) {
		model.addAttribute("titulo", "Inicio");
		return "index";
	}
	
	
}
