package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Membre_Publication;
import com.example.demo.entities.Membre;
import com.example.demo.entities.MembrePubsIds;

public interface MembrePubRepository extends JpaRepository<Membre_Publication, MembrePubsIds> {
	List<Membre_Publication> findByAuteur(Membre auteur);
}
