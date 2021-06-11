package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Sorcerer;

public interface ISorcererDao extends JpaRepository<Sorcerer, Integer>{

}
