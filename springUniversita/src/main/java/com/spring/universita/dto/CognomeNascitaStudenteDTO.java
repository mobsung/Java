package com.spring.universita.dto;

import java.time.LocalDate;

public class CognomeNascitaStudenteDTO {
	
	private String cognome;
	private LocalDate anno_di_nascita;
	
	public CognomeNascitaStudenteDTO(String cognome, LocalDate anno_di_nascita) {
		super();
		this.cognome = cognome;
		this.anno_di_nascita = anno_di_nascita;
	}
	
	public CognomeNascitaStudenteDTO() {
		
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getAnno_di_nascita() {
		return anno_di_nascita;
	}

	public void setAnno_di_nascita(LocalDate anno_di_nascita) {
		this.anno_di_nascita = anno_di_nascita;
	}
	
	
	

}
