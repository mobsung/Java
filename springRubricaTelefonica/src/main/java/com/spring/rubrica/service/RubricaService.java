package com.spring.rubrica.service;

import com.spring.rubrica.dto.*;

import java.time.LocalDate;
import java.util.List;

public interface RubricaService {

    void insert(RubricaDTO dto);

    void insertAll(List<RubricaDTO> rubricheDTO);

    RubricaDTO selectById(int id);

    List<RubricaDTO> selectAll();

    RubricaDTO delete(int id);

    RubricaProprietarioAnnoCreazioneDTO proprietarioAnnoCreazione(int id);

    RubricaDTO modifyProprietario(int id, String proprietario);

    RubricaDTO modifyAnnoCreazione(int id, LocalDate annoCreazione);

    RubricaNomiProprietariTotaleRubricheDTO nomiTotaleProprietari();

    RubricaProprietarioCreazionePiuVecchiaDTO nomiCreazionePiuVecchia();

    List<LocalDate> anniCreazioneAsc();

    RubricaProprietariTotaleContattiDTO propritariTotContatti(int id);

}
