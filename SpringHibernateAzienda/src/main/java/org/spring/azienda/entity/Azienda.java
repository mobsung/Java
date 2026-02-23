package org.spring.azienda.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Azienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String intestazione;
    private double capitale;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JoinColumn(name = "azienda")
    private List<Dipendente> dipendenti = new ArrayList<>();

    public Azienda(){}

    public Azienda(double capitale, String intestazione) {
        this.capitale = capitale;
        this.intestazione = intestazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntestazione() {
        return intestazione;
    }

    public void setIntestazione(String intestazione) {
        this.intestazione = intestazione;
    }

    public double getCapitale() {
        return capitale;
    }

    public void setCapitale(double capitale) {
        this.capitale = capitale;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti.addAll(dipendenti);
    }

    public void addDipendente(Dipendente dipendente){
        dipendenti.add(dipendente);
    }
}
