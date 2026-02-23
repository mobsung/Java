package org.spring.azienda.service;

import org.spring.azienda.dto.*;

import java.util.List;

public interface DipendenteService {

    void inserisciNoPA(int idAzienda, DipendenteDTO dto);

    void inserisciConPA(int idAzienda, DipendentePostoAutoDTO dto);

    void inserisciConPAID(int idAzienda, DipendenteIdPostoAutoDTO dto);

    List<DipendenteDTO> selectAll(int idAzienda);

    List<NomeCognomeDipendenteDTO> selectAllNomeCognome(int idAzienda);

    List<DipendenteDTO> selectAllDatoSalario(int idAzienda, double salario);

    DipendenteDTO deleteByMatricola(int idAzienda, int matricola);

    NomeCognomeDipendenteDTO deleteByMatricolaNomeCognome(int idAzienda, int matricola);

    DipendenteDTO spostaImpiegato(IdAziendaPartenzaArrivoDipendenteDTO dto);

    DipendenteDTO modificaSalario(int idAzienda, int matricola, double salario);

    DipendenteDTO modificaPostoAuto(int idAzienda, int matricola, int idPostoAuto);

    PostoAutoDTO visualizzaPostoAuto(int idAzienda, int matricola);


}
