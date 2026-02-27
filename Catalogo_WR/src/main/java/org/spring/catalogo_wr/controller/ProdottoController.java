package org.spring.catalogo_wr.controller;

import org.spring.catalogo_wr.dto.ProdottoDTO;
import org.spring.catalogo_wr.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/")
class ProdottoController {

    @Autowired
    ProdottoService serviceProd;

    @PostMapping(path = "/prodotti", consumes = "application/json")
    public void salva(@RequestBody ProdottoDTO dto){
        serviceProd.salva(dto);
    }

    @GetMapping(path = "/prodotti/{id}", produces = "application/json")
    public ProdottoDTO selezionaPerId(@PathVariable int id) {
        return serviceProd.selezionaPerID(id);
    }

    @GetMapping(path = "/prodotti/{id}/versione", produces = "application/json")
    public int selezionaVersione(@PathVariable int id){
        return serviceProd.selezionaVersione(id);
    }

    @GetMapping(path = "/prodotti", produces = "application/json")
    public List<ProdottoDTO> selezionaTutti(){
        return serviceProd.selezionaTutti();
    }

    @DeleteMapping(path = "/prodotti/{id}", produces = "application/json")
    public ProdottoDTO rimuovi(@PathVariable int id){
        return serviceProd.rimuovi(id);
    }

    @PatchMapping(path = "/prodotti/{id}/nome", produces = "application/json")
    public ProdottoDTO modificaNome(@PathVariable int id, String nome){
        return serviceProd.modificaNome(id, nome);
    }
}
