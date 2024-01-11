package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Publication  {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String type;
	@NonNull
	private String titre;
	@NonNull
	private String lien;
	@NonNull
	private Date date;
	@NonNull
	private String sourcePdf;
}
