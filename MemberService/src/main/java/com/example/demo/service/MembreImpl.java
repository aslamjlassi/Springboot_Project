package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.EnseignantRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MembreOutilRepository;
import com.example.demo.dao.MembrePubRepository;
import com.example.demo.dao.MembreRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.entities.MembreOutIds;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.entities.MembrePubsIds;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.proxies.OutilServiceProxy;
import com.example.demo.proxies.PublicationServiceProxy;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MembreImpl implements IMembreService {
	MembreRepository membrerepository;
	EtudiantRepository etudiantrepository;
	EnseignantRepository enseignantrepository;
	MembrePubRepository membrepubrepository;
	PublicationServiceProxy proxy;
	MembreOutilRepository membreoutrepository;
	OutilServiceProxy outproxy;
	@Override
	public Membre addMember(Membre m) {
		membrerepository.save(m);
		return m;
	}

	@Override
	public void deleteMember(Long id) {
		membrerepository.deleteById(id);

	}

	@Override
	public Membre updateMember(Membre m) {
		
		return membrerepository.saveAndFlush(m);
	}

	@Override
	public Membre findMember(Long id) {
		
		Membre m= membrerepository.findById(id).get();
		return m ;
	}

	@Override
	public List<Membre> findAll() {
		// TODO Auto-generated method stub
		return membrerepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {
		Membre m=(Membre)membrerepository.findByCin(cin);
		return m;
	}

	@Override
	public Membre findByEmail(String email) {
		Membre m=(Membre)membrerepository.findByEmail(email);
		return m;
	}

	@Override
	public List<Membre> findByNom(String nom) {
		// TODO Auto-generated method stub
		return membrerepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		// TODO Auto-generated method stub
		return etudiantrepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		// TODO Auto-generated method stub
		return enseignantrepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		// TODO Auto-generated method stub
		return enseignantrepository.findByEtablissement(etablissement);
	}

	@Override
	public List<Etudiant> findEtudiantByEnseignant(EnseignantChercheur ens) {
		
		return etudiantrepository.findByEncadrant(ens);
	}

	@Override
	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre mbr= membrerepository.findById(idauteur).get();
		Membre_Publication mbs= new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new MembrePubsIds(idpub, idauteur));
		membrepubrepository.save(mbs);
		
	}

	@Override
	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs=new ArrayList<PublicationBean>();
		Membre auteur= membrerepository.findById(idauteur).get();
		List< Membre_Publication>
		idpubs=membrepubrepository.findByAuteur(auteur);
		idpubs.forEach(s->{
		System.out.println(s);
		pubs.add(proxy.findPublicationById(s.getId().getPublication_id()));
		}
		);
		return pubs;
	}

	@Override
	public void affcteroutilTomembre(Long idauteur, Long idout) {
		Membre mbr= membrerepository.findById(idauteur).get();
		Membre_Outil mbo= new Membre_Outil();
		mbo.setMembre(mbr);
		mbo.setId(new MembreOutIds(idout, idauteur));
		membreoutrepository.save(mbo);
		
	}

	@Override
	public List<OutilBean> findOutilparmembre(Long idout) {
		// TODO Auto-generated method stub
		return null;
	}

}
