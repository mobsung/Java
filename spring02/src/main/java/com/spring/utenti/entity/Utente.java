package com.spring.utenti.entity;

public class Utente {
	
	private String nome, cognome, mail, telefono;
	private int idUtente;
	
	
	public Utente(String nome, String cognome, String mail, String telefono, int idUtente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.telefono = telefono;
		this.idUtente = idUtente;
	}
	
	public Utente() {
		System.out.println("Spring sta costruendo l'oggetto");
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", mail=" + mail + ", telefono=" + telefono
				+ ", idUtente=" + idUtente + "]";
	}
	
	
}
