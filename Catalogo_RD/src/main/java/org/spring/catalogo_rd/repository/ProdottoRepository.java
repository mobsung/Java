package org.spring.catalogo_rd.repository;

import org.spring.catalogo_rd.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
}
