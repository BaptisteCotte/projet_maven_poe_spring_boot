package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("equipes", mesEquipes);
		return "liste-equipe";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/ajouter")
	public String add(Model model) {
		List<Personnage> nosPersonnages = this.srvPersonnage.findAll();
		for (int i = 0; i < nosPersonnages.size(); i++) {

		}
		model.addAttribute("personnages", nosPersonnages);

		return "form-equipe";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/ajouter")
	public String add(@RequestParam int personnageR1, @RequestParam int personnageR2, @RequestParam int personnageR3,
			Model model) {

		if ((personnageR1 == personnageR2) || (personnageR1 == personnageR3) || (personnageR2 == personnageR3)) {
			model.addAttribute("erreur", "Vous ne pouvez pas sélectionner plusieurs fois le même personnage.");
			List<Personnage> nosPersonnages = this.srvPersonnage.findAll();
			model.addAttribute("personnages", nosPersonnages);
			return "form-equipe";
		}

		Personnage p1 = this.srvPersonnage.findById(personnageR1);

		Personnage p2 = this.srvPersonnage.findById(personnageR2);
		
		Personnage p3 = this.srvPersonnage.findById(personnageR3);
		
		Equipe equipe = new Equipe(p1,p2,p3);
		
		this.srvEquipe.add(equipe);
		
		return "redirect:liste";
		
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/combat")
	public String combat(@RequestParam int idEquipe1, @RequestParam int idEquipe2, @RequestParam String texte,@RequestParam int tour, Model model) {
	
	Equipe equipe1 = this.srvEquipe.findById(idEquipe1);
	Equipe equipe2 = this.srvEquipe.findById(idEquipe2);
	if(tour == 1) {
		if(!texte.equals("Debut combat")) {
			return "redirect:liste";
		}
	}
	
	Personnage e1p1 =  equipe1.getPer1();
	Personnage e1p2 =  equipe1.getPer2();
	Personnage e1p3 =  equipe1.getPer3();
	
	Personnage e2p1 =  equipe2.getPer1();
	Personnage e2p2 =  equipe2.getPer2();
	Personnage e2p3 =  equipe2.getPer3();
	
	model.addAttribute("equipe1", equipe1);

	model.addAttribute("equipe2", equipe2);

	model.addAttribute("texte",texte);
		return "combat";
	}
	
	@PostMapping("/combat")
	public String combat(@RequestParam int attack,@RequestParam int heal,@RequestParam String personnage, Model model) {

		
		
		return "combat";
		
	}

	


}
