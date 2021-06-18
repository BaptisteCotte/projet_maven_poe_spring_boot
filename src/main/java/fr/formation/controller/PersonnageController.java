package fr.formation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.model.Knight;
import fr.formation.model.Personnage;
import fr.formation.model.Priest;
import fr.formation.model.Sorcerer;
import fr.formation.request.PersonnageRequest;
import fr.formation.service.PersonnageService;

@Controller
@RequestMapping("/personnage")
public class PersonnageController {

	@Autowired
	private PersonnageService srvPersonnage;

	@GetMapping("/liste")
	public String findAll(Model model) {

		System.out.println("Rentré dans la liste des persos");
		List<Personnage> nosPersonnages = this.srvPersonnage.findAll();

		model.addAttribute("personnages", nosPersonnages);

		return "liste-perso";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/ajouter")
	public String add(Model model) {

		return "form-perso";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/ajouter")
	public String add(@Valid PersonnageRequest personnageR, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "form-perso";
		} else {
			if (personnageR.getClassePersonnageR().equals("sorcerer")) {
				Personnage personnage = new Sorcerer(personnageR.getName(), personnageR.getAge(),
						personnageR.getRace());

				this.srvPersonnage.add(personnage);
			} else if (personnageR.getClassePersonnageR().equals("knight")) {
				Personnage personnage = new Knight(personnageR.getName(), personnageR.getAge(), personnageR.getRace());
				this.srvPersonnage.add(personnage);
			} else {
				Personnage personnage = new Priest(personnageR.getName(), personnageR.getAge(), personnageR.getRace());
				this.srvPersonnage.add(personnage);
			}

			return "redirect:liste";
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/modifier")
	public String update(@RequestParam int id, Model model) {
		model.addAttribute("personnage", this.srvPersonnage.findById(id));

		return "form-modifier-perso";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/modifier")
	public String modifier(@RequestParam int id, @RequestParam String name, @RequestParam String age, Model model) {

		Personnage personnage = this.srvPersonnage.findById(id);
		personnage.setName(name);
		personnage.setAge(Integer.parseInt(age));
		this.srvPersonnage.update(personnage);

		return "redirect:liste";

	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/supprimer")
	public String deleteById(@RequestParam int id) {
		this.srvPersonnage.deleteById(id);

		return "redirect:liste";
	}
	
}
