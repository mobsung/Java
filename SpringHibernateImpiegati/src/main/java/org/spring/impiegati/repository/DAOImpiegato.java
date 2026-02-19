package org.spring.impiegati.repository;

import org.spring.impiegati.entity.Impiegato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DAOImpiegato extends JpaRepository<Impiegato, Integer> {

    @Query(nativeQuery = true, value = "select * from Impiegato order by nome")
    List<Impiegato> getImpiegatiOrdinatiNome();

    @Query(nativeQuery = true, value = "select * from Impiegato where salario = (select max(salario) from Impiegato)")
    List<Impiegato> getImpiegatoSalarioMaggiore();

}
