package com.example.demo.beans;

import java.util.Date;

import lombok.Data;

@Data
public class PublicationBean {
	private Long id;
	private String type;
	private String titre;
	private String lien;
	private Date date;
	private String sourcePdf;

}
