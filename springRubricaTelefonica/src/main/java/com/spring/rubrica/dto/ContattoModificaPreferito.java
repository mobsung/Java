package com.spring.rubrica.dto;

public class ContattoModificaPreferito extends ContattoIdDTO{

    private boolean preferito;

    public ContattoModificaPreferito(String nome, String cognome, boolean preferito) {
        super(nome, cognome);
        this.preferito = preferito;
    }

    public boolean isPreferito() {
        return preferito;
    }

    public void setPreferito(boolean preferito) {
        this.preferito = preferito;
    }
}
