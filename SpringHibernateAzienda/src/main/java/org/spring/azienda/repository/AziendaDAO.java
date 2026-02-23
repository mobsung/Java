package org.spring.azienda.repository;

import org.spring.azienda.dto.AziendaDatiBaseNDipendentiDTO;
import org.spring.azienda.dto.AziendaNoDipendentiDTO;
import org.spring.azienda.entity.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AziendaDAO extends JpaRepository<Azienda, Integer> {

    @Query(nativeQuery = true, value = "select id, intestazione, capitale from Azienda where :id = id")
    AziendaNoDipendentiDTO selectAziendaNoDipendenti(int id);

    @Query(nativeQuery = true, value = "select * from Azienda where capitale = (select max(capitale) from Azienda)")
    Azienda selectAziendaCapitaleMaggiore();
}
