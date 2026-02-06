package com.spring.rubrica.dto;

import java.time.LocalDate;

public class RubricaProprietarioCreazionePiuVecchiaDTO {
	
	private String proprietario;
	private LocalDate annoCreazione;
	
	public RubricaProprietarioCreazionePiuVecchiaDTO() {
		super();
	}

	public RubricaProprietarioCreazionePiuVecchiaDTO(String proprietario, LocalDate annoCreazione) {
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
	
	
}
