package org.spring.catalogo_rd.service.client;

import org.spring.catalogo_rd.dto.ProdottoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Catalogo_WR")
public interface ProdottoWrFeignClient {

    @GetMapping(path = "/prodotti/{id}/versione", produces = "application/json")
    int selezionaVersione(@PathVariable int id);

    @GetMapping(path = "/prodotti/{id}", produces = "application/json")
    ProdottoDTO selezionaPerId(@PathVariable int id);
}
