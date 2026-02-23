package org.spring.azienda.controller;

import org.spring.azienda.dto.AziendaDTO;
import org.spring.azienda.dto.AziendaDatiBaseNDipendentiDTO;
import org.spring.azienda.dto.AziendaNoDipendentiDTO;
import org.spring.azienda.service.AziendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/aziende")
public class AziendaController {

    @Autowired
    AziendaService aziendaService;

    @PostMapping(path = "/", consumes = "application/json")
    public void inserisciAzienda(@RequestBody AziendaDTO dto){
        aziendaService.inserisciAzienda(dto);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public AziendaDTO selectAziendaById(@PathVariable int id){
        return aziendaService.selectAziendaById(id);
    }

    @GetMapping(path = "/{id}/noDipendenti", produces = "application/json")
    public AziendaNoDipendentiDTO selectAziendaNoDipendenti(@PathVariable int id){
        return aziendaService.selectAziendaNoDipendenti(id);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<AziendaDTO> selectAll(){
        return aziendaService.selectAll();
    }

    @GetMapping(path = "/{id}/nDipendenti", produces = "application/json")
    public AziendaDatiBaseNDipendentiDTO selectAziendaDipendeti(@PathVariable int id){
        return aziendaService.selectAziendaDipendeti(id);
    }

    @GetMapping(path = "/capitale/maggiore", produces = "application/json")
    public AziendaDatiBaseNDipendentiDTO selectAziendaDipCapitaleMaggiore(){
        return aziendaService.selectAziendaDipCapitaleMaggiore();
    }

    @PatchMapping(path = "/{id}/capitale", produces = "application/json")
    public AziendaNoDipendentiDTO updateCapitale(@PathVariable int id, double capitale) {
        return aziendaService.updateCapitale(id, capitale);
    }

    @PatchMapping(path = "/{id}/intestazione", produces = "application/json")
    public AziendaNoDipendentiDTO updateIntestazione(@PathVariable int id, String intestazione) {
        return aziendaService.updateIntestazione(id, intestazione);
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public AziendaDTO deleteAziendaNoDipendenti(@PathVariable int id) {
        return aziendaService.deleteAziendaNoDipendenti(id);
    }
}
