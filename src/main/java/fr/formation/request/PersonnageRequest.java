package fr.formation.request;

import fr.formation.model.Race;

public class PersonnageRequest {
	
	protected String name;
	
	protected int age;
	
	protected Race race = Race.HUMAN;
	
	protected String classePersonnageR;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getClassePersonnageR() {
		return classePersonnageR;
	}

	public void setClassePersonnageR(String classePersonnageR) {
		this.classePersonnageR = classePersonnageR;
	}




}
