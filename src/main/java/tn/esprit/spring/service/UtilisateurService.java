package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Utilisateur;
import tn.esprit.spring.entities.Class;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.repository.ClassRepository;
import tn.esprit.spring.repository.UtilisateurRepository;

@Service
public class UtilisateurService implements IUtilisateurService{
	
	@Autowired
	UtilisateurRepository utilisateurrepository;
	@Autowired
	ClassRepository classRepository;

	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
		
		return utilisateurrepository.save(utilisateur);
	}

	@Override
	public void affecterUtilisateurClasse(int idUtilisateur, int idClass) {
		Utilisateur u = utilisateurrepository.findById(idUtilisateur).get();
		Class classe = classRepository.findById(idClass).get();
		
		u.setClasse(classe);
		utilisateurrepository.save(u);
		
	}

	@Override
	public int nbUtilisateurParNiveau(Niveau nv) {
		
		return utilisateurrepository.nbUtilisateurParNiveau(nv);
	}

}
