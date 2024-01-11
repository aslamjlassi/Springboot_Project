package com.example.demo.beans;

import java.util.Date;

import lombok.Data;

@Data
public class EvenementBean {
	private Long id;
	private String titre;
	private Date date;
	private String lieu;
}
