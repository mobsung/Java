package com.spring.universita.dto;

import java.time.LocalDate;

public class StudenteDTO {
	
	private String nome, cognome, indirizzo;
	private LocalDate anno_nascita, anno_immatricolazione;
	private int matricola;
	
	
	public StudenteDTO(String nome, String cognome, String indirizzo, LocalDate anno_nascita, LocalDate anno_immatricolazione,
			int matricola) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.anno_nascita = anno_nascita;
		this.anno_immatricolazione = anno_immatricolazione;
		this.matricola = matricola;
	}
	
	public StudenteDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getAnno_nascita() {
		return anno_nascita;
	}

	public void setAnno_nascita(LocalDate anno_nascita) {
		this.anno_nascita = anno_nascita;
	}

	public LocalDate getAnno_immatricolazione() {
		return anno_immatricolazione;
	}

	public void setAnno_immatricolazione(LocalDate anno_immatricolazione) {
		this.anno_immatricolazione = anno_immatricolazione;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
}
