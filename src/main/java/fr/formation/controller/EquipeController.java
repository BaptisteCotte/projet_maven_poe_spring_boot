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
import fr.formation.model.IHealer;
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
	
	if(texte.length()>450) {
		texte = texte.substring(texte.length()-450);
	}
	if(texte.contains("<")||texte.contains(">")||texte.contains("\"")) {
		texte = "ERROR";
		return "redirect:liste";
	}
	
	Personnage e1p1 =  equipe1.getPer1();
	Personnage e1p2 =  equipe1.getPer2();
	Personnage e1p3 =  equipe1.getPer3();
	
	Personnage e2p1 =  equipe2.getPer1();
	Personnage e2p2 =  equipe2.getPer2();
	Personnage e2p3 =  equipe2.getPer3();
	
	Personnage player = e1p1;
	
	if((e1p1.getId() == e2p1.getId())||(e1p1.getId() == e2p2.getId())||(e1p1.getId() == e2p3.getId())||(e1p2.getId() == e2p1.getId())||(e1p2.getId() == e2p2.getId())||(e1p3.getId() == e2p3.getId())||(e1p3.getId() == e2p1.getId())||(e1p3.getId() == e2p2.getId())||(e1p3.getId() == e2p3.getId())){
		return "redirect:liste";
	}
	
	if(!e1p1.isState()&&!e1p2.isState()&&!e1p3.isState()) {
		if(e2p1.isState()) {
			e2p1.regen();
			this.srvPersonnage.update(e2p1);
		}
		if(e2p2.isState()) {
			e2p2.regen();
			this.srvPersonnage.update(e2p2);
		}
		if(e2p3.isState()) {
			e2p3.regen();
			this.srvPersonnage.update(e2p3);
		}
		return "redirect:victoire?winner="+idEquipe2;
	}
	
	if(!e2p1.isState()&&!e2p2.isState()&&!e2p3.isState()) {
		if(e1p1.isState()) {
			e1p1.regen();
			this.srvPersonnage.update(e1p1);
		}
		if(e1p2.isState()) {
			e1p2.regen();
			this.srvPersonnage.update(e1p2);
		}
		if(e1p3.isState()) {
			e1p3.regen();
			this.srvPersonnage.update(e1p3);
		}
		return "redirect:victoire?winner="+idEquipe1;
	}
	
	
	if(tour==1) {
		if(e1p1.isState()) {
			player = e1p1;
		}else {
			tour++;
			return "redirect:combat?idEquipe1="+idEquipe1+"&idEquipe2="+idEquipe2+"&texte="+texte+"&tour="+tour;
		}
	}else if(tour==2) {
		if(e1p2.isState()) {
			player = e1p2;
		}else {
			tour++;
			return "redirect:combat?idEquipe1="+idEquipe1+"&idEquipe2="+idEquipe2+"&texte="+texte+"&tour="+tour;
		}
	}else if(tour==3) {
		if(e1p3.isState()) {
			player = e1p3;
		}else {
			tour++;
			return "redirect:combat?idEquipe1="+idEquipe1+"&idEquipe2="+idEquipe2+"&texte="+texte+"&tour="+tour;
		}
	}else if(tour==4) {
		if(e2p1.isState()) {
			player = e2p1;
		}else {
			tour++;
			return "redirect:combat?idEquipe1="+idEquipe1+"&idEquipe2="+idEquipe2+"&texte="+texte+"&tour="+tour;
		}
	}else if(tour==5) {
		if(e2p2.isState()) {
			player = e2p2;
		}else {
			tour++;
			return "redirect:combat?idEquipe1="+idEquipe1+"&idEquipe2="+idEquipe2+"&texte="+texte+"&tour="+tour;
		}
	}else if(tour==6) {
		if(e2p3.isState()) {
			player = e2p3;
		}else {
			tour = 1;
			return "redirect:combat?idEquipe1="+idEquipe1+"&idEquipe2="+idEquipe2+"&texte="+texte+"&tour="+tour;
		}
	}
	boolean isHealer = false;
	if(player instanceof IHealer) {
		isHealer = true;
	}

	model.addAttribute("player", player);
	
	model.addAttribute("equipe1", equipe1);

	model.addAttribute("equipe2", equipe2);

	model.addAttribute("texte",texte);
	
	model.addAttribute("tour",tour);
	
	model.addAttribute("isHealer",isHealer);
	
		return "combat";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/combat")
	public String combat(@RequestParam int idEquipe1, @RequestParam int idEquipe2, @RequestParam String texte,@RequestParam int tour,@RequestParam String cible, @RequestParam String action, @RequestParam int playerId,Model model) {
		System.out.println("idEquipe1="+idEquipe1);
		System.out.println("idEquipe2="+idEquipe2);
		System.out.println("texte="+texte);
		System.out.println("tour="+tour);
		System.out.println("cible="+cible);
		System.out.println("action="+action);
		System.out.println("playerId="+playerId);
		
		Personnage attaquant = this.srvPersonnage.findById(playerId);
		
		Personnage attaque;
		if(cible.equals("e1p1")) {
			attaque = this.srvEquipe.findById(idEquipe1).getPer1();
		}else if(cible.equals("e1p2")) {
			attaque = this.srvEquipe.findById(idEquipe1).getPer2();
		}else if(cible.equals("e1p3")) {
			attaque = this.srvEquipe.findById(idEquipe1).getPer3();
		}else if(cible.equals("e2p1")) {
			attaque = this.srvEquipe.findById(idEquipe2).getPer1();
		}else if(cible.equals("e2p2")) {
			attaque = this.srvEquipe.findById(idEquipe2).getPer2();
		}else{
			attaque = this.srvEquipe.findById(idEquipe2).getPer3();
		}
		
		tour++;
		if(tour>6) {
			tour = 1;
		}
		
		texte = texte+" "+attaquant.getName();
		
		if(action.equals("attack")) {
			if(attaque.isState()) {
				texte = texte+" attaque "+attaque.getName()+". ";
				int hpBefore = attaque.getHp();
				attaquant.attaquer(attaque);
				int hpAfter = attaque.getHp();
				int perdu = hpBefore - hpAfter;
				texte = texte+"La cible a perdu "+perdu+" hp. Il lui en reste "+hpAfter+".";
				if(!attaque.isState()) {
					texte = texte+" La cible est morte !";
				}
				this.srvPersonnage.update(attaque);
				
			} else {
				return "redirect:combat?idEquipe1="+idEquipe1+"&idEquipe2="+idEquipe2+"&texte="+texte+"&tour="+tour;
			}
		}
		if(action.equals("heal")) {
			if(attaque.isState()) {
				IHealer soigneur = (IHealer)attaquant;
				texte = texte+" soigne "+attaque.getName()+". ";
				int hpBefore = attaque.getHp();
				soigneur.heal(attaque);
				int hpAfter = attaque.getHp();
				int gagne = hpAfter - hpBefore;
				texte = texte+"La cible a gagne "+gagne+" hp. Il lui en a maintenant "+hpAfter+".";
				this.srvPersonnage.update(attaque);
			} else {
				return "redirect:combat?idEquipe1="+idEquipe1+"&idEquipe2="+idEquipe2+"&texte="+texte+"&tour="+tour;
			}
		}
		return "redirect:combat?idEquipe1="+idEquipe1+"&idEquipe2="+idEquipe2+"&texte="+texte+"&tour="+tour;
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/victoire")
	public String victoire(@RequestParam int winner, Model model) {
		
		Equipe equipe = this.srvEquipe.findById(winner);
		
		model.addAttribute("equipe", equipe);

		return "victoire";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/supprimer")
	public String supprimer(@RequestParam int id, Model model) {
		
		this.srvEquipe.deleteById(id);

		return "redirect:liste";
	}
	
}
