package org.spring.azienda.dto;

public class IdAziendaPartenzaArrivoDipendenteDTO {

    private int idAziendaPartenza, idAziendaArrivo, matricola;

    public IdAziendaPartenzaArrivoDipendenteDTO(int idAziendaPartenza, int idAziendaArrivo, int matricola) {
        this.idAziendaPartenza = idAziendaPartenza;
        this.idAziendaArrivo = idAziendaArrivo;
        this.matricola = matricola;
    }

    public int getIdAziendaPartenza() {
        return idAziendaPartenza;
    }

    public void setIdAziendaPartenza(int idAziendaPartenza) {
        this.idAziendaPartenza = idAziendaPartenza;
    }

    public int getIdAziendaArrivo() {
        return idAziendaArrivo;
    }

    public void setIdAziendaArrivo(int idAziendaArrivo) {
        this.idAziendaArrivo = idAziendaArrivo;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
}
