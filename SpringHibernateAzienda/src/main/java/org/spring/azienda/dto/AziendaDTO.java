package org.spring.azienda.dto;

import java.util.ArrayList;
import java.util.List;

public class AziendaDTO {

    private int id;
    private String intestazione;
    private double capitale;
    private List<DipendenteDTO> dipendenti = new ArrayList<>();

    public AziendaDTO(){}

    public AziendaDTO(double capitale, String intestazione) {
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

    public List<DipendenteDTO> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<DipendenteDTO> dipendenti) {
        this.dipendenti.addAll(dipendenti);
    }
}
