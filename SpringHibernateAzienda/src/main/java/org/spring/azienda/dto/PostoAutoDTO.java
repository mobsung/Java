package org.spring.azienda.dto;

public class PostoAutoDTO {

    private int id;

    private String posizione;

    public PostoAutoDTO(){}

    public PostoAutoDTO(String posizione) {
        this.posizione = posizione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }
}
