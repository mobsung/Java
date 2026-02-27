package org.spring.catalogo_wr.service;

import static org.spring.catalogo_wr.utility.Mapper.*;

import jakarta.transaction.Transactional;
import org.spring.catalogo_wr.dto.ProdottoDTO;
import org.spring.catalogo_wr.entity.Prodotto;
import org.spring.catalogo_wr.exceptions.IdFoundException;
import org.spring.catalogo_wr.exceptions.IdNotFoundException;
import org.spring.catalogo_wr.repository.ProdottoRepository;
import org.spring.catalogo_wr.utility.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
class ProdottoServiceImpl implements ProdottoService{

    @Autowired
    ProdottoRepository daoProd;

    @Override
    public void salva(ProdottoDTO dto) {
        if (daoProd.findById(dto.id()).isPresent()){
            throw new IdFoundException("Prodotto già presente");
        }
        daoProd.save(ProdottoDtoEntity(dto));
    }

    @Override
    public ProdottoDTO selezionaPerID(int id) {
        return ProdottoEntityDto(daoProd.findById(id).orElseThrow(
                () -> new IdNotFoundException("prodotto non trovato")
        ));
    }

    @Override
    public int selezionaVersione(int id) {
        Prodotto prodotto = daoProd.findById(id).orElseThrow(
                () -> new IdNotFoundException("prodotto non trovato"));
        return prodotto.getVersione();
    }

    @Override
    public List<ProdottoDTO> selezionaTutti() {
        return daoProd.findAll().stream()
                .map(Mapper::ProdottoEntityDto)
                .toList();
    }

    @Override
    public ProdottoDTO rimuovi(int id) {
        Prodotto prodotto = daoProd.findById(id).orElseThrow(
                () -> new IdNotFoundException("prodotto non trovato"));

        daoProd.deleteById(id);
        return ProdottoEntityDto(prodotto);
    }

    @Override
    public ProdottoDTO modificaNome(int id, String nome) {
        Prodotto prodotto = daoProd.findById(id).orElseThrow(
                () -> new IdNotFoundException("prodotto non trovato"));

        prodotto.setNome(nome);
        return ProdottoEntityDto(prodotto);
    }
}
