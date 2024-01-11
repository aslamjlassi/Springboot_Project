package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant>findByDiplome(String diplome);
	List<Etudiant>findByEncadrant(EnseignantChercheur ens);
}
