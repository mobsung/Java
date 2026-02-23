package org.spring.azienda.dto;

public class NomeCognomeDipendenteDTO {

    private String nome, cognome;

    public NomeCognomeDipendenteDTO(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
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
