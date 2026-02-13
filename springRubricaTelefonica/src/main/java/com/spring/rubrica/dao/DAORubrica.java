package com.spring.rubrica.dao;

import com.spring.rubrica.entity.Rubrica;

import java.util.List;

public interface DAORubrica {

    void registra(Rubrica rubrica);

    void registraTutti(List<Rubrica> rub);

    Rubrica findById(int id);

    List<Rubrica> selectAll();

    Rubrica delete(int id);
}
