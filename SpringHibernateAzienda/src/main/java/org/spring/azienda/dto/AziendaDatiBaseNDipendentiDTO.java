package org.spring.azienda.dto;

public class AziendaDatiBaseNDipendentiDTO {

    private int id;
    private String intestazione;
    private double capitale;
    private int numeroDipendenti;

    public AziendaDatiBaseNDipendentiDTO(int id, String intestazione, double capitale, int numeroDipendenti) {
        this.id = id;
        this.intestazione = intestazione;
        this.capitale = capitale;
        this.numeroDipendenti = numeroDipendenti;
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

    public int getNumeroDipendenti() {
        return numeroDipendenti;
    }

    public void setNumeroDipendenti(int numeroDipendenti) {
        this.numeroDipendenti = numeroDipendenti;
    }
}
