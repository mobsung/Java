package com.spring.rubrica.dto;

public class RubricaProprietariTotaleContattiDTO {
	
	private String proprietario;
	private int numeroContatti;
	
	public RubricaProprietariTotaleContattiDTO() {
		super();
	}

	public RubricaProprietariTotaleContattiDTO(String proprietario, int numeroContatti) {
		super();
		this.proprietario = proprietario;
		this.numeroContatti = numeroContatti;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public int getNumeroContatti() {
		return numeroContatti;
	}

	public void setNumeroContatti(int numeroContatti) {
		this.numeroContatti = numeroContatti;
	}
	
	

}
