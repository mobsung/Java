package org.spring.azienda.service;

import static org.spring.azienda.mapper.Mapper.*;
import jakarta.transaction.Transactional;
import org.spring.azienda.dto.*;
import org.spring.azienda.entity.Azienda;
import org.spring.azienda.entity.Dipendente;
import org.spring.azienda.entity.PostoAuto;
import org.spring.azienda.exceptions.IdNonPresenteException;
import org.spring.azienda.exceptions.IdPresenteException;
import org.spring.azienda.mapper.Mapper;
import org.spring.azienda.repository.AziendaDAO;
import org.spring.azienda.repository.PostoAutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DipendenteServiceImpl implements DipendenteService{

    @Autowired
    AziendaDAO daoAzienda;

    @Autowired
    PostoAutoDAO daoPostoAuto;

    private Azienda verifyAzienda(int id){
        if(daoAzienda.findById(id).isEmpty()){
            throw new IdNonPresenteException("L'azienda con ID: " + " non presente");
        }
        return daoAzienda.findById(id).get();
    }

    @Override
    public void inserisciNoPA(int idAzienda, DipendenteDTO dto) {
        Azienda azienda = verifyAzienda(idAzienda);
        if(azienda.getDipendenti().contains(DipendenteDtoEntity(dto))){
            throw new IdPresenteException("Il dipendente con Matricola: " + dto.getMatricola() + " già presente");
        }
        azienda.addDipendente(DipendenteDtoEntity(dto));
    }

    @Override
    public void inserisciConPA(int idAzienda, DipendentePostoAutoDTO dto) {
        Azienda azienda = verifyAzienda(idAzienda);
        if(azienda.getDipendenti().contains(DipendenteDtoEntity(dto.getDipendente()))){
            throw new IdPresenteException("Il dipendente con Matricola: " + dto.getDipendente().getMatricola() + " già presente");
        }
        Dipendente dipendente = DipendenteDtoEntity(dto.getDipendente());
        dipendente.setPostoAuto(PostoAutoDtoEntity(dto.getPostoAuto()));
        azienda.addDipendente(dipendente);
    }

    @Override
    public void inserisciConPAID(int idAzienda, DipendenteIdPostoAutoDTO dto) {
        Azienda azienda = verifyAzienda(idAzienda);
        if(daoPostoAuto.findById(dto.getIdPostoAuto()).isEmpty()){
            throw new IdNonPresenteException("Il posto auto con ID: " + dto.getIdPostoAuto() + " non trovato");
        }
        PostoAuto postoAuto = daoPostoAuto.findById(dto.getIdPostoAuto()).get();
        if(azienda.getDipendenti().stream()
                .anyMatch(d -> d.getPostoAuto().equals(postoAuto))){
            throw new IdPresenteException("Il posto auto con ID: " + " è già assegnato");
        }
        Dipendente dipendente = DipendenteDtoEntity(dto.getDipendenteDTO());
        dipendente.setPostoAuto(postoAuto);
        azienda.addDipendente(dipendente);
    }

    @Override
    public List<DipendenteDTO> selectAll(int idAzienda) {
        Azienda azienda = verifyAzienda(idAzienda);
        return azienda.getDipendenti().stream()
                .map(Mapper::DipendenteEntityDto)
                .toList();
    }

    @Override
    public List<NomeCognomeDipendenteDTO> selectAllNomeCognome(int idAzienda) {
        Azienda azienda = verifyAzienda(idAzienda);
        return azienda.getDipendenti().stream()
                .map(d -> new NomeCognomeDipendenteDTO(d.getNome(), d.getCognome()))
                .toList();
    }

    @Override
    public List<DipendenteDTO> selectAllDatoSalario(int idAzienda, double salario) {
        Azienda azienda = verifyAzienda(idAzienda);
        return azienda.getDipendenti().stream()
                .filter(d -> d.getSalario() == salario)
                .map(Mapper::DipendenteEntityDto)
                .toList();
    }

    @Override
    public DipendenteDTO deleteByMatricola(int idAzienda, int matricola) {
        Azienda azienda = verifyAzienda(idAzienda);
        return null;
    }

    @Override
    public NomeCognomeDipendenteDTO deleteByMatricolaNomeCognome(int idAzienda, int matricola) {
        Azienda azienda = verifyAzienda(idAzienda);
        return null;
    }

    @Override
    public DipendenteDTO spostaImpiegato(IdAziendaPartenzaArrivoDipendenteDTO dto) {
        Azienda aziendaPartenza = verifyAzienda(dto.getIdAziendaPartenza());
        Azienda aziendaArrivo = verifyAzienda(dto.getIdAziendaArrivo());
        return null;
    }

    @Override
    public DipendenteDTO modificaSalario(int idAzienda, int matricola, double salario) {
        Azienda azienda = verifyAzienda(idAzienda);
        return null;
    }

    @Override
    public DipendenteDTO modificaPostoAuto(int idAzienda, int matricola, int idPostoAuto) {
        Azienda azienda = verifyAzienda(idAzienda);
        return null;
    }

    @Override
    public PostoAutoDTO visualizzaPostoAuto(int idAzienda, int matricola) {
        Azienda azienda = verifyAzienda(idAzienda);
        return null;
    }
}
