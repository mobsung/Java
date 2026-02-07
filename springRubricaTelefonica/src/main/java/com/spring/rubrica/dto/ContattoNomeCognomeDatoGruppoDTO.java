package com.spring.rubrica.dto;

public class ContattoNomeCognomeDatoGruppoDTO {

    private String nome, cognome;

    public ContattoNomeCognomeDatoGruppoDTO(){

    }

    public ContattoNomeCognomeDatoGruppoDTO(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
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
}
