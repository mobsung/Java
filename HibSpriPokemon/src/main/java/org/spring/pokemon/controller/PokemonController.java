package org.spring.pokemon.controller;


import org.spring.pokemon.dto.PokemonDTO;
import org.spring.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/pokedex")
public class PokemonController {

    @Autowired
    PokemonService service;

    @PostMapping(path = "/pokemons", consumes = "application/json")
    public void addPokemon(@RequestBody PokemonDTO dto){
        service.add(dto);
    }

    @GetMapping(path = "/pokemons/{id}", produces = "application/json")
    public PokemonDTO findPokemonById(@PathVariable int id){
        return service.selectById(id);
    }

    @GetMapping(path = "/pokemons/all", produces = "application/json")
    public List<PokemonDTO> selectAll(){
        return service.selectAll();
    }

    @DeleteMapping(path = "/pokemons/{id}", produces = "application/json")
    public PokemonDTO deletePokemon(@PathVariable int id){
        return service.delete(id);
    }
}
