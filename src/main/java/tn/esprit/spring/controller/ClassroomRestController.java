package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Specialite;
import tn.esprit.spring.service.IClassroomService;

@RestController
@RequestMapping("/classroom")
public class ClassroomRestController {
	@Autowired
	IClassroomService classroomService;
	
	@PostMapping("/add-classroom/{idClass}")
	public CoursClassroom ajouterCoursClassroom(@RequestBody CoursClassroom cc,@PathVariable("idClass") int codeClass) {
		return classroomService.ajouterCoursClassroom(cc, codeClass);
		
	}
	
	@PutMapping("/desaffecteClass/{idCours}")
	public void desaffecterCoursClassroomClass(@PathVariable("idCours")int idCours) {
		
		classroomService.desaffecterCoursClassroomClass(idCours);
	}
	@GetMapping("/nbHeuresParSpecEtNiv/{specialite}/{niveau}")
	public int nbHeuresParSpecEtNiv(@PathVariable("specialite")Specialite sp,@PathVariable("niveau") Niveau nv) {
		return classroomService.nbHeuresParSpecEtNiv(sp, nv);
		
	}
}
