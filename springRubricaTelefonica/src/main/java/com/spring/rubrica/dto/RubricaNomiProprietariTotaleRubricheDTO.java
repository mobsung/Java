package com.spring.rubrica.dto;

import java.util.List;

public class RubricaNomiProprietariTotaleRubricheDTO {
	private List<String> nomiProprietari;
	private int totaleRubriche;
	
	public RubricaNomiProprietariTotaleRubricheDTO() {
	}

	public RubricaNomiProprietariTotaleRubricheDTO(List<String> nomiProprietari, int totaleRubriche) {
		super();
		this.nomiProprietari = nomiProprietari;
		this.totaleRubriche = totaleRubriche;
	}

	public List<String> getNomiProprietari() {
		return nomiProprietari;
	}

	public void setNomiProprietari(List<String> nomiProprietari) {
		this.nomiProprietari = nomiProprietari;
	}

	public int getTotaleRubriche() {
		return totaleRubriche;
	}

	public void setTotaleRubriche(int totaleRubriche) {
		this.totaleRubriche = totaleRubriche;
	}
	
	
	
	

}
