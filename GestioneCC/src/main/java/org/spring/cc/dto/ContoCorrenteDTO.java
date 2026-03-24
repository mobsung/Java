package org.spring.cc.dto;

import org.spring.cc.entity.Movimento;
import org.spring.cc.entity.Utente;

import java.time.LocalDate;
import java.util.List;

public record ContoCorrenteDTO(
        String numeroConto,
        double saldo,
        LocalDate dataApertura,
        Utente intestatario,
        Utente coIntestatario,
        List<Movimento> movimenti
    ) {
}
