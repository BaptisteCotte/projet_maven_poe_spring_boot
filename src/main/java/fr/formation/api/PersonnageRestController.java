package fr.formation.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import fr.formation.exception.PersonnageNotValidException;
import fr.formation.model.Knight;
import fr.formation.model.Personnage;
import fr.formation.model.Priest;
import fr.formation.model.Sorcerer;
import fr.formation.request.PersonnageRequest;
import fr.formation.service.PersonnageService;

@RestController
@RequestMapping("/api/personnage")
@CrossOrigin("*")
public class PersonnageRestController {
	
	@Autowired
	private PersonnageService srvPersonnage;
	
	@GetMapping
	public List<Personnage> findAll(){
		return this.srvPersonnage.findAll();
	}
	
	@GetMapping("{/id}")
	public Personnage findById(@PathVariable int id) {
		
		
		return this.srvPersonnage.findById(id);
		
	}
	
	@PostMapping("/api/ajouterpersonnage")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Personnage add(@Valid PersonnageRequest personnageR, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			
			throw new PersonnageNotValidException();
			
		} else {
			if(personnageR.getClassePersonnageR().toLowerCase().equals("sorcerer") ) {
				Personnage personnage = new Sorcerer(personnageR.getName(),personnageR.getAge(),personnageR.getRace());
				
				return this.srvPersonnage.add(personnage);
			}else if (personnageR.getClassePersonnageR().toLowerCase().equals("knight")) {
				Personnage personnage = new Knight(personnageR.getName(),personnageR.getAge(),personnageR.getRace());
				return this.srvPersonnage.add(personnage);
			}else {
				Personnage personnage = new Priest(personnageR.getName(),personnageR.getAge(),personnageR.getRace());
				return this.srvPersonnage.add(personnage);
			}
			

		}
	}
	
	@PutMapping("/modifier/{id}")
	public boolean update(@PathVariable int id, @Valid @RequestBody Personnage personnage, BindingResult result) {
		if (result.hasErrors()) {
			return false;
		}
		
		personnage.setId(id); //Pour �tre s�r de faire un update au lieu d'un insert
		this.srvPersonnage.update(personnage);
		return true;
	}
	
	@DeleteMapping("/supprimer/{id}")
	public boolean deleteById(@PathVariable int id) {
		this.srvPersonnage.deleteById(id);
		return true;
	}
	
}
