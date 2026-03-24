package org.spring.cc.dto;

import org.spring.cc.entity.Indirizzo;

public record UtenteDTO(
        int idUtente,
        String nome,
        String cognome,
        String mail,
        String telefono,
        Indirizzo indirizzo
    ) {
}
