package com.spring.universita.dto;

public class ProfessoreDTO {
	
	private int id;
	private String nome, cognome, materia_insegnamento;
	
	public ProfessoreDTO(int id, String nome, String cognome, String materia_insegnamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.materia_insegnamento = materia_insegnamento;
	}
	
	public ProfessoreDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getMateria_insegnamento() {
		return materia_insegnamento;
	}

	public void setMateria_insegnamento(String materia_insegnamento) {
		this.materia_insegnamento = materia_insegnamento;
	}
	
	

}
