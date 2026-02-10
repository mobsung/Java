package org.spring.aop.entity;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Artista {
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void perform(){
        if (new Random().nextBoolean())
            System.out.println("Din din din");
        else
            throw new RuntimeException();
    }
}
