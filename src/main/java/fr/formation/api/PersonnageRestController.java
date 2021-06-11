package fr.formation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dao.IPersonnageDao;
import fr.formation.model.Personnage;

@RestController
@RequestMapping("/api/personnage")
public class PersonnageRestController {
	@Autowired
	private IPersonnageDao daoPerso;
	
	@GetMapping
	public List<Personnage> findAll(){
		return this.daoPerso.findAll();
	}
}
