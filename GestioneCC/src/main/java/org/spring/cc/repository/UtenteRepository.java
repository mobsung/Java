package org.spring.cc.repository;

import org.spring.cc.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Integer, Utente> {
}
