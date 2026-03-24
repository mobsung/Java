package org.spring.cc.entity;

import jakarta.persistence.*;

@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtente;

    @Column(unique = true, nullable = false)
    private String mail;

    private String nome, cognome, telefono;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "indirizzo")
    private Indirizzo indirizzo;

    public Utente(){}

    public Utente(int idUtente, String mail, String nome, String cognome, String telefono, Indirizzo indirizzo) {
        this.idUtente = idUtente;
        this.mail = mail;
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }
}
