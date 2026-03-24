package org.spring.cc.dto;

public record IndirizzoDTO(
        String indirizzo,
        String via,
        String cap,
        String citta,
        String provincia
    ) {
}
