package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Membre;
import com.example.demo.entities.MembreOutIds;
import com.example.demo.entities.Membre_Outil;

public interface MembreOutilRepository extends JpaRepository<Membre_Outil, MembreOutIds> {
	List<Membre_Outil> findByMembre(Membre membre);
}
