package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Priest;

public interface IPriestDao extends JpaRepository<Priest, Integer>{

}
