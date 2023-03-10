package tn.esprit.spring.service;

import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Specialite;

public interface IClassroomService {
	
	public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, int codeClass);
	public void desaffecterCoursClassroomClass(int idCours);
	public void archiverCoursClassroom();
	public int nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);

}
