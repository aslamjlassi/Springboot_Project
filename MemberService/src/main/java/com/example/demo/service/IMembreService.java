package com.example.demo.service;

import java.util.List;

import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

public interface IMembreService {
	public Membre addMember(Membre m);
	public void deleteMember(Long id) ;
	public Membre updateMember(Membre p) ;
	public Membre findMember(Long id) ;
	public List<Membre> findAll();
	
	public Membre findByCin(String cin);
	public Membre findByEmail(String email);
	public List<Membre> findByNom(String nom);
	
	public List<Etudiant> findByDiplome(String diplome);
	
	public List<EnseignantChercheur> findByGrade(String grade);
	public List<EnseignantChercheur> findByEtablissement(String etablissement);
	public List<Etudiant> findEtudiantByEnseignant(EnseignantChercheur ens);
	
	public void affecterauteurTopublication(Long idauteur, Long idpub);
	public List<PublicationBean> findPublicationparauteur (Long idauteur);
	
	public void affcteroutilTomembre(Long idauteur,Long idout);
	public List<OutilBean> findOutilparmembre(Long idout);
}
