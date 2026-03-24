package org.spring.cc.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Indirizzo {

    @Id
    private String indirizzo;
    private String via, cap, citta, provincia;

    public Indirizzo(){}

    public Indirizzo(String indirizzo, String via, String cap, String citta, String provincia) {
        this.indirizzo = indirizzo;
        this.via = via;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
