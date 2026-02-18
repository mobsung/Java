package org.spring.pokemon.service;

import static org.spring.pokemon.mapper.Mapper.*;
import jakarta.transaction.Transactional;
import org.spring.pokemon.dto.PokemonDTO;
import org.spring.pokemon.entity.Pokemon;
import org.spring.pokemon.mapper.Mapper;
import org.spring.pokemon.repository.DAOPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PokemonServiceImpl implements PokemonService{

    @Autowired
    private DAOPokemon dao;

    @Override
    public void add(PokemonDTO dto) {
        dao.save(PokemonDtoEntity(dto));
    }

    @Override
    public PokemonDTO selectById(int id) {
        if(dao.findById(id).isPresent()){
            return PokemonEntityDto(dao.findById(id).get() );
        }
        return null;
    }

    @Override
    public List<PokemonDTO> selectAll() {
        return dao.findAll().stream()
                .map(Mapper::PokemonEntityDto)
                .toList();
    }

    @Override
    public PokemonDTO delete(int id) {
        if(dao.findById(id).isPresent()){
            Pokemon pokemon = dao.findById(id).get();
            dao.deleteById(id);
            return PokemonEntityDto(pokemon);
        }
        return null;
    }


}
