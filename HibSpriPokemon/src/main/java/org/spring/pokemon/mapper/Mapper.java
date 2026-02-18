package org.spring.pokemon.mapper;

import org.spring.pokemon.dto.PokemonDTO;
import org.spring.pokemon.entity.Pokemon;

public class Mapper {

    public static PokemonDTO PokemonEntityDto(Pokemon pokemon){
        return new PokemonDTO(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getType()
        );
    }

    public static Pokemon PokemonDtoEntity(PokemonDTO dto){
        return new Pokemon(
                dto.getId(),
                dto.getName(),
                dto.getType()
        );
    }

}
