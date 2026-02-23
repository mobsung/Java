package org.spring.azienda.service;

import org.spring.azienda.dto.AziendaDTO;
import org.spring.azienda.dto.AziendaDatiBaseNDipendentiDTO;
import org.spring.azienda.dto.AziendaNoDipendentiDTO;

import java.util.List;

public interface AziendaService {

    void inserisciAzienda(AziendaDTO dto);

    AziendaDTO selectAziendaById(int id);

    AziendaNoDipendentiDTO selectAziendaNoDipendenti(int id);

    List<AziendaDTO> selectAll();

    AziendaDatiBaseNDipendentiDTO selectAziendaDipendeti(int id);

    AziendaDatiBaseNDipendentiDTO selectAziendaDipCapitaleMaggiore();

    AziendaNoDipendentiDTO updateCapitale(int id, double capitale);

    AziendaNoDipendentiDTO updateIntestazione(int id, String intestazione);

    AziendaDTO deleteAziendaNoDipendenti(int id);


}
