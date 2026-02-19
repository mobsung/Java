package org.spring.impiegati.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Impiegato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricola;

    private String nome, cognome;
    private double salario;
    private LocalDate dataAssunzione;

    public Impiegato(){}

    public Impiegato(String nome, String cognome, double salario, LocalDate dataAssunzione) {
        this.nome = nome;
        this.cognome = cognome;
        this.salario = salario;
        this.dataAssunzione = dataAssunzione;
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
}
