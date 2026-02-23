package org.spring.azienda.dto;

public class DipendentePostoAutoDTO {

    private DipendenteDTO dipendente;
    private PostoAutoDTO postoAuto;

    public DipendentePostoAutoDTO(DipendenteDTO dipendente, PostoAutoDTO postoAuto) {
        this.dipendente = dipendente;
        this.postoAuto = postoAuto;
    }

    public DipendenteDTO getDipendente() {
        return dipendente;
    }

    public void setDipendente(DipendenteDTO dipendente) {
        this.dipendente = dipendente;
    }

    public PostoAutoDTO getPostoAuto() {
        return postoAuto;
    }

    public void setPostoAuto(PostoAutoDTO postoAuto) {
        this.postoAuto = postoAuto;
    }
}
