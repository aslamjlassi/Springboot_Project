package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity @DiscriminatorValue("ens")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnseignantChercheur extends Membre implements Serializable {
private String grade;
private String etablissement;
@Builder
public EnseignantChercheur(@NonNull String cin, @NonNull String nom, @NonNull String prenom,
		@NonNull Date dateNaissance, @NonNull byte[] photo, @NonNull String cv, @NonNull String email,
		@NonNull String password, String grade, String etablissement) {
	super(cin, nom, prenom, dateNaissance, photo, cv, email, password);
	this.grade = grade;
	this.etablissement = etablissement;
}


	
}
