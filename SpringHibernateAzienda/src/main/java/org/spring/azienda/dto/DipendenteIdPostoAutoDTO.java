package org.spring.azienda.dto;

public class DipendenteIdPostoAutoDTO {

    private int idPostoAuto;
    private DipendenteDTO dipendenteDTO;

    public DipendenteIdPostoAutoDTO(int idPostoAuto, DipendenteDTO dipendenteDTO) {
        this.idPostoAuto = idPostoAuto;
        this.dipendenteDTO = dipendenteDTO;
    }

    public int getIdPostoAuto() {
        return idPostoAuto;
    }

    public void setIdPostoAuto(int idPostoAuto) {
        this.idPostoAuto = idPostoAuto;
    }

    public DipendenteDTO getDipendenteDTO() {
        return dipendenteDTO;
    }

    public void setDipendenteDTO(DipendenteDTO dipendenteDTO) {
        this.dipendenteDTO = dipendenteDTO;
    }
}
