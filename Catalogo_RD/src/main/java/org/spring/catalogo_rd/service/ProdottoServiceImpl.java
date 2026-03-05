package org.spring.catalogo_rd.service;

import org.spring.catalogo_rd.dto.ProdottoDTO;
import org.spring.catalogo_rd.entity.Prodotto;
import org.spring.catalogo_rd.exceptions.IdNotFoundException;
import org.spring.catalogo_rd.repository.ProdottoRepository;
import org.spring.catalogo_rd.service.client.ProdottoWrFeignClient;
import static org.spring.catalogo_rd.utility.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoServiceImpl implements ProdottoService{

    @Autowired
    private ProdottoRepository dao;

    @Autowired
    private ProdottoWrFeignClient pfc;

    private void aggiorna(int versione, Prodotto p){
        
    }

    @Override
    public ProdottoDTO selezionaProdottoPerId(int id) {

        if(dao.findById(id).get().getVersione() != pfc.selezionaVersione(id)){
            dao.findById(id).get().setVersione(pfc.selezionaVersione(id));
            return ProdottoEntityDto(dao.findById(id).get());
        } else if (dao.findById(id).get().getVersione() == pfc.selezionaVersione(id)){
            return ProdottoEntityDto(dao.findById(id).get());
        }

        Prodotto pfeign = ProdottoDtoEntity(pfc.selezionaPerId(id));
        if (pfeign == null) throw new IdNotFoundException("prodotto non trovato");

        if (dao.findById(id).isEmpty()){
            dao.save(pfeign);
            return ProdottoEntityDto(pfeign);
        }

        throw new IdNotFoundException("prodotto non trovato");

    }

    @Override
    public List<ProdottoDTO> selezionaTutti() {
        return List.of();
    }
}
