package org.spring.pokemon.repository;

import org.spring.pokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOPokemon extends JpaRepository<Pokemon, Integer> {
}
