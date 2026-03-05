package org.spring.catalogo_rd.entity;

import jakarta.persistence.*;

@Entity
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private double prezzo;
    private int quantita;
    private int versione;

    public Prodotto(){}

    public Prodotto(int quantita, double prezzo, String nome, int versione) {
        this.quantita = quantita;
        this.prezzo = prezzo;
        this.nome = nome;
        this.versione = versione;
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

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getVersione() {
        return versione;
    }

    public void setVersione(int versione) {
        this.versione = versione;
    }
}
