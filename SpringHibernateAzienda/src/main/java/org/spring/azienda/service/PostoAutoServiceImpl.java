package org.spring.azienda.service;

import static org.spring.azienda.mapper.Mapper.*;

import jakarta.transaction.Transactional;
import org.spring.azienda.dto.PostoAutoDTO;
import org.spring.azienda.entity.PostoAuto;
import org.spring.azienda.exceptions.IdNonPresenteException;
import org.spring.azienda.exceptions.IdPresenteException;
import org.spring.azienda.mapper.Mapper;
import org.spring.azienda.repository.PostoAutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostoAutoServiceImpl implements PostoAutoService{

    @Autowired
    PostoAutoDAO daoPostoAuto;

    @Override
    public void inserisciPostoAuto(PostoAutoDTO dto) {
        if(daoPostoAuto.findById(dto.getId()).isPresent()){
            throw new IdPresenteException("Il posto auto con ID: " + " già presente");
        }
        daoPostoAuto.save(PostoAutoDtoEntity(dto));
    }

    @Override
    public List<PostoAutoDTO> selectAll() {
        return daoPostoAuto.findAll().stream()
                .map(Mapper::PostoAutoEntityDto)
                .toList();
    }

    @Override
    public PostoAutoDTO selectPostoAutoById(int id) {
        if(daoPostoAuto.findById(id).isEmpty()){
            throw new IdNonPresenteException("Il posto auto con ID: " + " non presente");
        }
        return PostoAutoEntityDto(daoPostoAuto.findById(id).get());
    }

    @Override
    public PostoAutoDTO deletePostoAuto(int id) {
        if(daoPostoAuto.findById(id).isEmpty()){
            throw new IdNonPresenteException("Il posto auto con ID: " + " non presente");
        }
        PostoAuto pa = daoPostoAuto.findById(id).get();
        daoPostoAuto.deleteById(id);
        return PostoAutoEntityDto(pa);
    }
}
