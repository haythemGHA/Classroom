package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Class;
import tn.esprit.spring.service.IClassService;

@RestController
@RequestMapping("/classe")
public class ClassRestController {
	@Autowired
	IClassService classService;
	
	@PostMapping("/add-class")
	public void ajouterClasse(@RequestBody Class c) {
		classService.ajouterClasse(c);
	}
	

}
