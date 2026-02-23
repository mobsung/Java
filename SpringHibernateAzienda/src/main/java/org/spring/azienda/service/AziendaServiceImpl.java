package org.spring.azienda.service;

import static org.spring.azienda.mapper.Mapper.*;

import jakarta.transaction.Transactional;
import org.spring.azienda.dto.AziendaDTO;
import org.spring.azienda.dto.AziendaDatiBaseNDipendentiDTO;

import org.spring.azienda.dto.AziendaNoDipendentiDTO;
import org.spring.azienda.entity.Azienda;
import org.spring.azienda.exceptions.AziendaContieneDipendentiException;
import org.spring.azienda.exceptions.IdPresenteException;
import org.spring.azienda.exceptions.IdNonPresenteException;
import org.spring.azienda.exceptions.AzniendeNonPresentiException;
import org.spring.azienda.mapper.Mapper;
import org.spring.azienda.repository.AziendaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AziendaServiceImpl implements AziendaService{

    @Autowired
    AziendaDAO daoAzienda;

    @Override
    public void inserisciAzienda(AziendaDTO dto) {
        if(daoAzienda.findById(dto.getId()).isPresent()){
            System.out.println("exc");
            throw new IdPresenteException("L'azienda con ID: " + dto.getId() + " è già presente");
        }
        daoAzienda.save(AziendaDtoEntity(dto));

    }

    @Override
    public AziendaDTO selectAziendaById(int id) {
        if(daoAzienda.findById(id).isEmpty()){
            throw new IdNonPresenteException("L'azienda con ID: " + id + " non è stata trovata");
        }
        return AziendaEntityDto(daoAzienda.findById(id).get());
    }

    @Override
    public AziendaNoDipendentiDTO selectAziendaNoDipendenti(int id) {
        return daoAzienda.selectAziendaNoDipendenti(id);
    }

    @Override
    public List<AziendaDTO> selectAll() {
        return daoAzienda.findAll().stream()
                .map(Mapper::AziendaEntityDto)
                .toList();
    }

    @Override
    public AziendaDatiBaseNDipendentiDTO selectAziendaDipendeti(int id) {
        if(daoAzienda.findById(id).isEmpty()){
            throw new IdNonPresenteException("L'azienda con ID: " + id + " non è stata trovata");
        }
        return new AziendaDatiBaseNDipendentiDTO(
                daoAzienda.findById(id).get().getId(),
                daoAzienda.findById(id).get().getIntestazione(),
                daoAzienda.findById(id).get().getCapitale(),
                daoAzienda.findById(id).get().getDipendenti().size()
        );
    }

    @Override
    public AziendaDatiBaseNDipendentiDTO selectAziendaDipCapitaleMaggiore() {
        Azienda azienda = daoAzienda.selectAziendaCapitaleMaggiore();
        if(azienda == null){
            throw new AzniendeNonPresentiException("Non è stata trovata alcuna azienda");
        }
        return new AziendaDatiBaseNDipendentiDTO(
                azienda.getId(),
                azienda.getIntestazione(),
                azienda.getCapitale(),
                azienda.getDipendenti().size()
        );
    }

    @Override
    public AziendaNoDipendentiDTO updateCapitale(int id, double capitale) {
        if(daoAzienda.findById(id).isEmpty()){
            throw new IdNonPresenteException("L'azienda con ID: " + id + " non è stata trovata");
        }
        Azienda azienda = daoAzienda.findById(id).get();
        azienda.setCapitale(capitale);
        return new AziendaNoDipendentiDTO(
                azienda.getId(),
                azienda.getIntestazione(),
                azienda.getCapitale()
        );
    }

    @Override
    public AziendaNoDipendentiDTO updateIntestazione(int id, String intestazione) {
        if(daoAzienda.findById(id).isEmpty()){
            throw new IdNonPresenteException("L'azienda con ID: " + id + " non è stata trovata");
        }
        Azienda azienda = daoAzienda.findById(id).get();
        azienda.setIntestazione(intestazione);
        return new AziendaNoDipendentiDTO(
                azienda.getId(),
                azienda.getIntestazione(),
                azienda.getCapitale()
        );
    }

    @Override
    public AziendaDTO deleteAziendaNoDipendenti(int id) {
        if(daoAzienda.findById(id).isEmpty()){
            throw new IdNonPresenteException("L'azienda con ID: " + id + " non è stata trovata");
        }
        if(daoAzienda.findById(id).get().getDipendenti().isEmpty()){
            throw new AziendaContieneDipendentiException("Azienda contiene dipendenti");
        }
        Azienda azienda = daoAzienda.findById(id).get();
        daoAzienda.deleteById(id);
        return AziendaEntityDto(azienda);
    }
}
