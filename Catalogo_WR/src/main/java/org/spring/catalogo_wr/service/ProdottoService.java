package org.spring.catalogo_wr.service;

import org.spring.catalogo_wr.dto.ProdottoDTO;

import java.util.List;

public interface ProdottoService {

    void salva(ProdottoDTO dto);

    ProdottoDTO selezionaPerID(int id);

    int selezionaVersione(int id);

    List<ProdottoDTO> selezionaTutti();

    ProdottoDTO rimuovi(int id);

    ProdottoDTO modificaNome(int id, String nome);

}
