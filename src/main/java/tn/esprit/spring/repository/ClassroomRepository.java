package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CoursClassroom;
import tn.esprit.spring.entities.Niveau;
import tn.esprit.spring.entities.Specialite;

@Repository
public interface ClassroomRepository extends JpaRepository<CoursClassroom, Integer>{
	@Query("Select sum(c.nbHeures) from CoursClassroom c join c.classe cs where c.specialite=:sp and cs.niveau=:nv ")
	int nbHeuresParSpecRtNiv(@Param("sp")Specialite sp,@Param("nv") Niveau nv);

}
