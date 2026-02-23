package org.spring.azienda.dto;

public class AziendaNoDipendentiDTO {

    private int id;
    private String intestazione;
    private double capitale;

    public AziendaNoDipendentiDTO(int id, String intestazione, double capitale) {
        this.id = id;
        this.intestazione = intestazione;
        this.capitale = capitale;
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
}
