package org.spring.impiegati.repository;

import org.spring.impiegati.entity.Impiegato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOImpiegato extends JpaRepository<Impiegato, Integer> {
}
