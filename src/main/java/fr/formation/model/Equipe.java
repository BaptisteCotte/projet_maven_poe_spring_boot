package fr.formation.model;

import javax.persistence.*;


@Entity
@Table(name = "equipe")
public class Equipe {

	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EQU_ID")
	protected int id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EQU_PER_1", referencedColumnName = "PER_ID")
	protected Personnage per1;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EQU_PER_2", referencedColumnName = "PER_ID")
	protected Personnage per2;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EQU_PER_3", referencedColumnName = "PER_ID")
	protected Personnage per3 ;
	
	@Column(name = "EQU_WIN")
	protected int win = 0;
	
	@Column(name = "EQU_STATE")
	protected boolean state = true;
	
	//Constructeur
	public Equipe() {}
	
	

	public Equipe(Personnage per1, Personnage per2, Personnage per3) {
		this.per1 = per1;
		this.per2 = per2;
		this.per3 = per3;
	}



	//Accesseurs
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Personnage getPer1() {
		return per1;
	}



	public void setPer1(Personnage per1) {
		this.per1 = per1;
	}



	public Personnage getPer2() {
		return per2;
	}



	public void setPer2(Personnage per2) {
		this.per2 = per2;
	}



	public Personnage getPer3() {
		return per3;
	}



	public void setPer3(Personnage per3) {
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
	
	
}
