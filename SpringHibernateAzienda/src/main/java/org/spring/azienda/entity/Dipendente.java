package org.spring.azienda.entity;

import jakarta.persistence.*;

@Entity
public class Dipendente {

    @Id
    private int matricola;

    private String nome, cognome;
    private double salario;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "postoAuto")
    private PostoAuto postoAuto;

    public Dipendente(){}

    public Dipendente(double salario, String cognome, String nome) {
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

    public PostoAuto getPostoAuto() {
        return postoAuto;
    }

    public void setPostoAuto(PostoAuto postoAuto) {
        this.postoAuto = postoAuto;
    }
}
