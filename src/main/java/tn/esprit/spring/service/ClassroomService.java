package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Specialite;
import tn.esprit.spring.entities.Class;
import tn.esprit.spring.repository.ClassRepository;
import tn.esprit.spring.repository.ClassroomRepository;

@Service
public class ClassroomService implements IClassroomService{

	@Autowired 
	ClassroomRepository classromRepository;
	@Autowired
	ClassRepository classRepository;
	
	@Override
	public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, int codeClass) {
		CoursClassroom cours = classromRepository.save(cc);
		Class c = classRepository.findById(codeClass).get();
		
		cours.setClasse(c);
		
		
		
		
		return classromRepository.save(cours);
	}

	@Override
	public void desaffecterCoursClassroomClass(int idCours) {
		
		CoursClassroom cours = classromRepository.findById(idCours).get();
		cours.setClasse(null);
		classromRepository.save(cours);
		
	}

	@Override
	@Scheduled(cron = "*/60 * * * * *")
	public void archiverCoursClassroom() {
		List<CoursClassroom> cours =  classromRepository.findAll();
		for (CoursClassroom c : cours) {
			c.setArchive(true);
			classromRepository.save(c);
		}
		
		
	}

	@Override
	public int nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
		
		return classromRepository.nbHeuresParSpecRtNiv(sp, nv);
	}

}
