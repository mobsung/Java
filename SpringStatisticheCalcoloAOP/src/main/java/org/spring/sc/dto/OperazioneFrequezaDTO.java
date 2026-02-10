package org.spring.sc.dto;

public class OperazioneFrequezaDTO {

    private String operazione;
    private int frequenza;

    public OperazioneFrequezaDTO(String operazione, int frequenza) {
        this.operazione = operazione;
        this.frequenza = frequenza;
    }

    public OperazioneFrequezaDTO(){}

    public String getOperazione() {
        return operazione;
    }

    public void setOperazione(String operazione) {
        this.operazione = operazione;
    }

    public int getFrequenza() {
        return frequenza;
    }

    public void setFrequenza(int frequenza) {
        this.frequenza = frequenza;
    }
}
