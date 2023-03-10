package tn.esprit.spring.service;

import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Utilisateur;

public interface IUtilisateurService {

	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
	public void affecterUtilisateurClasse(int idUtilisateur, int idClass);
	public int nbUtilisateurParNiveau(Niveau niveau);
	
}
