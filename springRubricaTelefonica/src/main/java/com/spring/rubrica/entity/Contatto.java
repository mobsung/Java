package com.spring.rubrica.entity;

import java.time.LocalDate;
import java.util.Objects;


public class Contatto {
	private String nome, cognome, numero, gruppoAppartenenza;
	private LocalDate dataNascita;
	private boolean preferito;
	
	
	public Contatto() {

	}

	public Contatto(String nome, String cognome, String numero, String gruppoAppartenenza, LocalDate dataNascita,
			boolean preferito) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.gruppoAppartenenza = gruppoAppartenenza;
		this.dataNascita = dataNascita;
		this.preferito = preferito;
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


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getGruppoAppartenenza() {
		return gruppoAppartenenza;
	}


	public void setGruppoAppartenenza(String gruppoAppartenenza) {
		this.gruppoAppartenenza = gruppoAppartenenza;
	}


	public LocalDate getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}


	public boolean isPreferito() {
		return preferito;
	}


	public void setPreferito(boolean preferito) {
		this.preferito = preferito;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatto other = (Contatto) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(nome, other.nome);
	}
	
	
	
}
