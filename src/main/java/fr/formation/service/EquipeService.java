package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IEquipeDao;
import fr.formation.model.Equipe;


@Service
public class EquipeService {

	@Autowired
	private IEquipeDao daoEquipe;
	
	public List<Equipe> findAll(){
		return this.daoEquipe.findAll();
	}
	
	public Equipe findById(int id) {
		Optional<Equipe> op = this.daoEquipe.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public Equipe add(Equipe entity) {
		return this.daoEquipe.save(entity);
	}
	
	public Equipe update(Equipe entity) {
		return this.daoEquipe.save(entity);
	}
	
	public void deleteById(int id) {
		
		this.daoEquipe.deleteById(id);
		
	}
}
