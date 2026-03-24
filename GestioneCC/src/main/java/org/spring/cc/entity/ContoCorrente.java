package org.spring.cc.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ContoCorrente {

    @Id
    private String numeroConto;

    private double saldo;
    private LocalDate dataApertura;

    @ManyToOne
    @JoinColumn(name = "intestatario_id_utente", nullable = false)
    private Utente intestatario;

    @ManyToOne
    @JoinColumn(name = "coIntestatario_id_utente")
    private Utente coIntestatario;

    @OneToMany
    @JoinColumn(name = "contoCorrente_id")
    private List<Movimento> movimenti = new ArrayList<>();

    public ContoCorrente(){}

    public ContoCorrente(String numeroConto, double saldo, LocalDate dataApertura, Utente intestatario) {
        this.numeroConto = numeroConto;
        this.saldo = saldo;
        this.dataApertura = dataApertura;
        this.intestatario = intestatario;
    }

    public ContoCorrente(String numeroConto, double saldo, LocalDate dataApertura, Utente intestatario, Utente coIntestatario) {
        this.numeroConto = numeroConto;
        this.saldo = saldo;
        this.dataApertura = dataApertura;
        this.intestatario = intestatario;
        this.coIntestatario = coIntestatario;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataApertura() {
        return dataApertura;
    }

    public void setDataApertura(LocalDate dataApertura) {
        this.dataApertura = dataApertura;
    }

    public Utente getIntestatario() {
        return intestatario;
    }

    public void setIntestatario(Utente intestatario) {
        this.intestatario = intestatario;
    }

    public Utente getCoIntestatario() {
        return coIntestatario;
    }

    public void setCoIntestatario(Utente coIntestatario) {
        this.coIntestatario = coIntestatario;
    }

    public List<Movimento> getMovimenti(){
        return movimenti;
    }

    public void setMovimenti(List<Movimento> movimenti){
        this.movimenti.addAll(movimenti);
    }
}
