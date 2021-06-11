package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IPersonnageDao;
import fr.formation.model.Personnage;

@Service
public class PersonnageService {

	@Autowired
	private IPersonnageDao daoPersonnage;
	
	public List<Personnage> findAll(){
		return this.daoPersonnage.findAll();
	}
	
	public Personnage findById(int id) {
		Optional<Personnage> op = this.daoPersonnage.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public Personnage add(Personnage entity) {
		return this.daoPersonnage.save(entity);
	}
	
	public Personnage update(Personnage entity) {
		return this.daoPersonnage.save(entity);
	}
	
	public void deleteById(int id) {
		
		this.daoPersonnage.deleteById(id);
		
	}
	
}
