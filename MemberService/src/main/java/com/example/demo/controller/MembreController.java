package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.service.IMembreService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
public class MembreController {

	
	IMembreService membreService;
	@GetMapping(value="/membres")
	public List<Membre> findMembres (){
	return membreService.findAll();
	}
	@GetMapping(value="/membres/{id}")
	public Membre findOneMemberById(@PathVariable Long id){
	return membreService.findMember(id);
	}
	@GetMapping(value="/membres/search/cin")
	public Membre findOneMemberByCin(@RequestParam String cin)
	{
	return membreService.findByCin(cin);
	}
	@GetMapping(value="/membres/search/email")
	public Membre findOneMemberByEmail(@RequestParam String email)
	{
	return membreService.findByEmail(email);
	}
	@PostMapping(value="/membres/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m)
	{
	return membreService.addMember(m);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/membres/etudiant")
	public Membre addMembre(@RequestBody Etudiant e)
	{
	return membreService.addMember(e);
	}
	@DeleteMapping(value="/membres/{id}")
	public void deleteMembre(@PathVariable Long id)
	{

	membreService.deleteMember(id);

	}
	@PutMapping(value="/membres/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody
	Etudiant p)
	{

	p.setId(id);
	return membreService.updateMember(p);

	}
	@PutMapping(value="/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody
	EnseignantChercheur p)
	{

	p.setId(id);
	return membreService.updateMember(p);

	}
	
	@GetMapping("/fullmember/{id}")
	public Membre findAFullMember(@PathVariable(name="id") Long id)
	{

	Membre mbr=membreService.findMember(id);
	mbr.setPubs(membreService.findPublicationparauteur(id));

	return mbr;
	}
}
