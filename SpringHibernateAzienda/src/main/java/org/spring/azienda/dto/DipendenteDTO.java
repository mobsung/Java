package org.spring.azienda.dto;


public class DipendenteDTO {

    private int matricola;
    private String nome, cognome;
    private double salario;
    private PostoAutoDTO postoAuto;

    public DipendenteDTO(){}

    public DipendenteDTO(double salario, String cognome, String nome) {
        this.salario = salario;
        this.cognome = cognome;
        this.nome = nome;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public PostoAutoDTO getPostoAuto() {
        return postoAuto;
    }

    public void setPostoAuto(PostoAutoDTO postoAuto) {
        this.postoAuto = postoAuto;
    }
}
