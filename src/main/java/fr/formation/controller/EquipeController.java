package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.model.Equipe;
import fr.formation.model.Personnage;
import fr.formation.service.EquipeService;
import fr.formation.service.PersonnageService;

@Controller
@RequestMapping("/equipe")
public class EquipeController {

	@Autowired
	private EquipeService srvEquipe;
	@Autowired
	private PersonnageService srvPersonnage;
	@GetMapping("/liste")
	public String findAll(Model model) {
		List<Equipe> mesEquipes = this.srvEquipe.findAll();
		model.addAttribute("equipes",mesEquipes);
		return "liste-equipe";
	}
	@GetMapping("/ajouter")
	public String add(Model model) {
		List<Personnage> nosPersonnages = this.srvPersonnage.findAll();
		model.addAttribute("personnages", nosPersonnages );
		
		return "form-equipe";
	}
	
}
