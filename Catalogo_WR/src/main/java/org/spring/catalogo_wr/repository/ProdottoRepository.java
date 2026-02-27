package org.spring.catalogo_wr.repository;

import org.spring.catalogo_wr.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {
}
