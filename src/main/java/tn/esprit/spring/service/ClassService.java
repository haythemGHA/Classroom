package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Class;
import tn.esprit.spring.repository.ClassRepository;

@Service
public class ClassService implements IClassService{

	@Autowired
	ClassRepository classRepository;
	@Override
	public void ajouterClasse(Class c) {
		classRepository.save(c);
		
	}

}
