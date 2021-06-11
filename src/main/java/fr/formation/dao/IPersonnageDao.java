package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Personnage;

public interface IPersonnageDao extends JpaRepository<Personnage, Integer>{



}
