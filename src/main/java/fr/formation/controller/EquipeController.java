package fr.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Equipe;
import fr.formation.model.Knight;
import fr.formation.model.Personnage;
import fr.formation.model.Priest;
import fr.formation.model.Sorcerer;
import fr.formation.request.PersonnageRequest;
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
		model.addAttribute("equipes", mesEquipes);
		return "liste-equipe";
	}

	@GetMapping("/ajouter")
	public String add(Model model) {
		List<Personnage> nosPersonnages = this.srvPersonnage.findAll();
		model.addAttribute("personnages", nosPersonnages);

		return "form-equipe";
	}

	@PostMapping("/ajouter")
	public String add(@Valid PersonnageRequest personnageR1, @Valid PersonnageRequest personnageR2,
			@Valid PersonnageRequest personnageR3, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "form-equipe";
		} else {
			System.out.println(" id persoR :" + personnageR1.getId() +" ,"+personnageR2.getId() +" ,"+personnageR3.getId() +" ,");
			if ((personnageR1.getId() == personnageR2.getId()) || (personnageR1.getId() == personnageR3.getId())
					|| (personnageR2.getId() == personnageR3.getId())) {
				model.addAttribute("erreur", "Vous ne pouvez pas sélectionner plusieurs fois le même personnage.");
				return "form-equipe";
			}
			Personnage personnage1 = this.createPersonnage(personnageR1);
			personnage1.setId(personnageR1.getId());

			Personnage personnage2 = this.createPersonnage(personnageR2);
			personnage2.setId(personnageR2.getId());

			Personnage personnage3 = this.createPersonnage(personnageR3);
			personnage3.setId(personnageR3.getId());
			
			Equipe equipe = new Equipe(personnage1, personnage2, personnage3);
			this.srvEquipe.add(equipe);

			return "redirec:liste";
		}
	}
	
	public Personnage createPersonnage(PersonnageRequest p) {
		System.out.println(p.getClassePersonnageR());
		if(p.getClassePersonnageR().equals("sorcerer")) {
			Personnage personnage = new Sorcerer();
			return personnage;
		}else if(p.getClassePersonnageR().equals("knight")) {
			Personnage personnage = new Knight();
			return personnage;
		}else {
			Personnage personnage = new Priest();
			return personnage;
		}
		
	}

	
}
