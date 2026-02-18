package org.spring.pokemon.service;

import org.spring.pokemon.dto.PokemonDTO;

import java.util.List;

public interface PokemonService {

    void add(PokemonDTO dto);

    PokemonDTO selectById(int id);

    List<PokemonDTO> selectAll();

    PokemonDTO delete(int id);


}
