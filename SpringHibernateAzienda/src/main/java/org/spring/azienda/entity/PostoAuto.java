package org.spring.azienda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PostoAuto postoAuto = (PostoAuto) o;
        return id == postoAuto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
