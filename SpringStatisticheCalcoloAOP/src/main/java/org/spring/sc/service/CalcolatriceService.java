package org.spring.sc.service;

import org.spring.sc.entity.Calcolatrice;
import org.springframework.stereotype.Service;


@Service
public class CalcolatriceService {

    public double somma(double a, double b){
        return Calcolatrice.somma(a, b);
    }

    public double sottrazione(double a, double b){
        return Calcolatrice.sottrai(a, b);
    }

    public double moltiplicazione(double a, double b){
        return Calcolatrice.moltiplica(a, b);
    }

    public double divisione(double a, double b){
        return Calcolatrice.dividi(a, b);
    }
}
