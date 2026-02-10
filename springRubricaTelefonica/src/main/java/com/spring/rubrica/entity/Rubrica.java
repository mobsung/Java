package com.spring.rubrica.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Rubrica {
	
	private int id;
	private String proprietario;
	private LocalDate annoCreazione;
	private HashSet<Contatto> contatti = new HashSet<>();
	
	public Rubrica() {

	}

	public Rubrica(String proprietario, LocalDate annoCreazione) {
		super();
		this.proprietario = proprietario;
		this.annoCreazione = annoCreazione;
	}
	

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public LocalDate getAnnoCreazione() {
		return annoCreazione;
	}

	public void setAnnoCreazione(LocalDate annoCreazione) {
		this.annoCreazione = annoCreazione;
	}

	public HashSet<Contatto> getContatti() {
		return contatti;
	}
	
	public boolean addContatto(Contatto contatto) {
		return contatti.add(contatto);
	}

	public void setContatti(HashSet<Contatto> contatti) {
		this.contatti = contatti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
