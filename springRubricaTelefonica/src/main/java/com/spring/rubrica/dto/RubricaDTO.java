package com.spring.rubrica.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class RubricaDTO {
	
	private int id;
	private String proprietario;
	private LocalDate annoCreazione;
	private HashSet<ContattoDTO> contatti = new HashSet<ContattoDTO>();
	
	public RubricaDTO() {

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

	public HashSet<ContattoDTO> getContatti() {
		return contatti;
	}
	
	public void setContatti(Set<ContattoDTO> c) {
		contatti.addAll(c);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
