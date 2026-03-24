package org.spring.cc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Entity
@Check(constraints = "importo > 0")
public class Movimento {

    public enum Tipo{
        VERSAMENTO,
        PRELIEVO
    }

    @Id
    private int idMovimento;
    private Tipo tipo;
    private double importo;
    private LocalDate dataOperazione;

    @ManyToOne
    @JoinColumn(name = "operatore_id_utente")
    private Utente operatore;

    public Movimento(){}

    public Movimento(Utente operatore, LocalDate dataOperazione, double importo, Tipo tipo, int idMovimento) {
        this.operatore = operatore;
        this.dataOperazione = dataOperazione;
        this.importo = importo;
        this.tipo = tipo;
        this.idMovimento = idMovimento;
        this.operatore = operatore;
    }

    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public LocalDate getDataOperazione() {
        return dataOperazione;
    }

    public void setDataOperazione(LocalDate dataOperazione) {
        this.dataOperazione = dataOperazione;
    }

    public Utente getOperatore() {
        return operatore;
    }

    public void setOperatore(Utente operatore) {
        this.operatore = operatore;
    }
}
