package org.spring.sc.controller;

import org.spring.sc.service.CalcolatriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/calcola")
public class CalcolatriceController {

    @Autowired
    CalcolatriceService service;

    @GetMapping(path="/somma/ab")
    public double somma(double a, double b){
        return service.somma(a, b);
    }

    @GetMapping(path="/sottrazione/ab")
    public double sottrazione(double a, double b){
        return service.sottrazione(a, b);
    }

    @GetMapping(path="/moltiplicazione/ab")
    public double moltiplicazione(double a, double b){
        return service.moltiplicazione(a, b);
    }

    @GetMapping(path="/divisione/ab")
    public double divisione(double a, double b){
        return service.divisione(a, b);
    }
}
