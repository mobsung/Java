package com.spring.universita.dto;

import java.time.LocalDate;

public class CognomeAnnoIscrizioneStudentePiuTempo {
	
	private String cognome;
	private LocalDate anno_iscrizione;
	public CognomeAnnoIscrizioneStudentePiuTempo(String cognome, LocalDate anno_iscrizione) {
		super();
		this.cognome = cognome;
		this.anno_iscrizione = anno_iscrizione;
	}
	
	public CognomeAnnoIscrizioneStudentePiuTempo() {

	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getAnno_iscrizione() {
		return anno_iscrizione;
	}

	public void setAnno_iscrizione(LocalDate anno_iscrizione) {
		this.anno_iscrizione = anno_iscrizione;
	}
	
	

}
