package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Utilisateur;
import tn.esprit.spring.service.IUtilisateurService;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurRestController {
	
	@Autowired
	IUtilisateurService utilisateurservice;
	
	@PostMapping("/add-user")
	public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurservice.ajouterUtilisateur(utilisateur);
		
	}
	@PostMapping("/affectation-user/{idUtilisateur}/{idClass}")
	public void affecterUtilisateurClasse(@PathVariable("idUtilisateur")int idUtilisateur,@PathVariable("idClass") int idClass) {
		utilisateurservice.affecterUtilisateurClasse(idUtilisateur, idClass);
	}

	@GetMapping("/nbUserParNiveau/{niveau}")
	public int nbUtilisateurParNiveau(@PathVariable("niveau")Niveau niveau) {
		return utilisateurservice.nbUtilisateurParNiveau(niveau);
	}
}
