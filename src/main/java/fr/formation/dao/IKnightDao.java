package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Knight;

public interface IKnightDao extends JpaRepository<Knight, Integer>{

}
