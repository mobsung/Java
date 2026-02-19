package org.spring.azienda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PostoAuto {

    @Id
    private int id;

    private String posizione;

    public PostoAuto(){}

    public PostoAuto(String posizione) {
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
