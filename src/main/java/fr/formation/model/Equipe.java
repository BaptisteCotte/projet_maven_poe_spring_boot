package fr.formation.model;

import javax.persistence.*;

import fr.formation.service.PersonnageService;

@Entity
@Table(name = "equipe")
public class Equipe {

	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EQU_ID")
	protected int id;
	
	@Column(name = "EQU_PER_1")
	@JoinColumn(name = "PER_ID")
	protected int per1 = 0;
	
	@Column(name = "EQU_PER_2")
	@JoinColumn(name = "PER_ID")
	protected int per2 = 0;
	
	@Column(name = "EQU_PER_3")
	@JoinColumn(name = "PER_ID")
	protected int per3 = 0;
	
	@Column(name = "EQU_WIN")
	protected int win = 0;
	
	@Column(name = "EQU_STATE")
	protected boolean state = true;
	
	//Constructeur
	public Equipe() {}
	
	public Equipe(Personnage per1,Personnage per2,Personnage per3) {
		this.per1 = per1.getId();
		this.per2 = per2.getId();
		this.per3 = per3.getId();
	}

	//Accesseurs
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPer1() {
		return per1;
	}

	public void setPer1(int per1) {
		this.per1 = per1;
	}

	public int getPer2() {
		return per2;
	}

	public void setPer2(int per2) {
		this.per2 = per2;
	}

	public int getPer3() {
		return per3;
	}

	public void setPer3(int per3) {
		this.per3 = per3;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public Personnage getPer1AsPersonnage() {
		PersonnageService ps = new PersonnageService();
		return ps.findById(this.getPer1());
	}
	
	public Personnage getPer2AsPersonnage() {
		PersonnageService ps = new PersonnageService();
		return ps.findById(this.getPer2());
	}
	
	public Personnage getPer3AsPersonnage() {
		PersonnageService ps = new PersonnageService();
		return ps.findById(this.getPer3());
	}
	
}
