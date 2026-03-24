package org.spring.cc.dto;

import org.spring.cc.entity.Movimento.Tipo;

import java.time.LocalDate;

public record MovimentoDTO(
        int idMovimento,
        Tipo tipo,
        double importo,
        LocalDate dataOperazione,
        UtenteDTO operatore
    ) {
}
