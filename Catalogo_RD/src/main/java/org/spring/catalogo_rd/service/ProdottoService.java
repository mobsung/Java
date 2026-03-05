package org.spring.catalogo_rd.service;

import org.spring.catalogo_rd.dto.ProdottoDTO;

import java.util.List;

public interface ProdottoService {

    ProdottoDTO selezionaProdottoPerId(int id);

    List<ProdottoDTO> selezionaTutti();


}
