package com.spring.rubrica.service;


import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.ContattoIdDTO;
import com.spring.rubrica.dto.ContattoModificaPreferito;
import com.spring.rubrica.dto.ContattoNomeCognomeDatoGruppoDTO;

import java.util.List;

public interface ContattoService {

    void insertContatto(int id, ContattoDTO contattoDto);

    ContattoDTO selectById(int id, ContattoIdDTO dto);

    ContattoDTO modifyContatto(int id, ContattoDTO c);

    ContattoDTO deleteContatto(int id, ContattoIdDTO dto);

    List<ContattoDTO> selectAllContatti(int id);

    int numeroContatti(int id);

    ContattoDTO selectContattoByNumero(int id, String numero);

    List<ContattoNomeCognomeDatoGruppoDTO> selectContattiPerGruppo(int id, String gruppo);

    int totaleContattiGruppo(int id, String gruppo);

    List<ContattoDTO> cancellaContattiGruppo(int id, String gruppo);

    ContattoDTO modifyPreferito(int id, ContattoModificaPreferito dto);

    List<ContattoDTO> findPreferiti(int id);

}
