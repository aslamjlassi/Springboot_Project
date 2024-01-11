package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MembreRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.service.IMembreService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableDiscoveryClient
@EnableFeignClients
public class MemberServiceApplication implements CommandLineRunner {
	MembreRepository membrerepository;
	IMembreService membreservice;
	
	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		byte[] tab;
		// TODO Auto-generated method stub
		Etudiant etd1= Etudiant.builder()
				.cin("123456")
				.cv("sjsssksksk")
				.email("kslslslslsl")
				.diplome("ingenieur")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.password("pass1")
				.encadrant(null)
				.nom("ssjss")
				.prenom("shfhd")
				.sujet("Microservice")
				.photo(tab=new byte[12])
				.build();
		membreservice.addMember(etd1);
		//membrerepository.save(etd1);
		Etudiant etd2= Etudiant.builder()
				.cin("1234555")
				.cv("sjsssksksk")
				.email("kslslslslsl")
				.diplome("mastere")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.password("pass1")
				.encadrant(null)
				.nom("mohamed")
				.prenom("mohamed")
				.sujet("Blockchain")
				.photo(tab=new byte[12])
				.build();
		membreservice.addMember(etd2);
		//membrerepository.save(etd2);
		EnseignantChercheur ens1=EnseignantChercheur.builder()
				.cin("126496")
				.nom("Riadh")
				.prenom("Salah")
				.dateNaissance(new Date())
				.photo(tab)
				.cv("skssslsmm")
				.email("sjskslsms")
				.password("passs3")
				.grade("Docteur")
				.etablissement("ENIS")
				.build();
		membreservice.addMember(ens1);
		Etudiant etd3= Etudiant.builder()
				.cin("1234558")
				.cv("sjsssksksk")
				.email("kslslslslsl")
				.diplome("mastere")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.password("pass1")
				.encadrant(null)
				.nom("salah")
				.prenom("salah")
				.sujet("DevOps")
				.photo(tab=new byte[12])
				.encadrant(ens1)
				.build();
		membreservice.addMember(etd3);
		//membrerepository.save(etd3);
		
		
		//membrerepository.save(ens1);
		/*
		List<Membre> mbrs=membrerepository.findAll();
		for(Membre membre:mbrs) {
			System.out.println(membre.getNom()+" "+ membre.getPrenom());
		}
		
		Membre e1=membrerepository.findById(1L).get();
		System.out.println(e1.getNom());
		
		e1.setEmail("sldkqsls@gmail.com");
		membrerepository.save(e1);*/
		List<Etudiant> etds= membreservice.findEtudiantByEnseignant(ens1);
		for(Etudiant e:etds) {
			System.out.println(e.getNom());
		}
		
		membreservice.affecterauteurTopublication(1L, 1L);
		membreservice.affecterauteurTopublication(1L, 2L);
	}

}
