package org.spring.impiegati.controller;


import org.spring.impiegati.dto.ImpiegatoDTO;
import org.spring.impiegati.dto.NomeCognomeDTO;
import org.spring.impiegati.entity.Impiegato;
import org.spring.impiegati.mapper.MapperImpiegato;
import org.spring.impiegati.service.ImpiegatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import static org.spring.impiegati.mapper.MapperImpiegato.ImpiegatoEntityDto;

@RestController
@RequestMapping(path = "/impiegati")
public class ImpiegatoController {

    @Autowired
    ImpiegatoService service;

    @PostMapping(path = "/")
    public void assumi(@RequestBody ImpiegatoDTO dto){
        service.assumi(dto);
    }

    @GetMapping(path = "/{matricola}")
    public ImpiegatoDTO cercaPerMatricola(@PathVariable int matricola) {
        return service.cercaPerMatricola(matricola);
    }

    @GetMapping(path = "/all")
    public List<ImpiegatoDTO> visualizzaTutti() {
        return service.visualizzaTutti();
    }

    @DeleteMapping(path = "{matricola}")
    public ImpiegatoDTO cancellaPerMatricola(@PathVariable int matricola) {
        return service.cancellaPerMatricola(matricola);
    }

    @PatchMapping(path = "/{matricola}")
    public ImpiegatoDTO modificaSalario(@PathVariable int matricola, double nuovoSalario) {
        return service.modificaSalario(matricola, nuovoSalario);
    }

    @DeleteMapping(path = "/{matricola}/cnomeCognome")
    public NomeCognomeDTO cancellaConNomeCognome(@PathVariable int matricola) {
        return service.cancellaConNomeCognome(matricola);
    }

    @GetMapping(path = "/all/order/matricola")
    public List<NomeCognomeDTO> visualizzaOrdinatiMatricola() {
        return service.visualizzaOrdinatiMatricola();
    }


    public double visualizzaTotSalarioMese() {
        return service.visualizzaTotSalarioMese();
    }


    public List<ImpiegatoDTO> visualizzaOrdinatiCognome() {
        return service.visualizzaOrdinatiCognome();
    }


    public ImpiegatoDTO visualizzaAssunzionePiuVecchia() {
        return service.visualizzaAssunzionePiuVecchia();
    }


    public ImpiegatoDTO visualizzaSalarioMaggioreDatoTempo(LocalDate data) {
        return service.visualizzaSalarioMaggioreDatoTempo(data);
    }

}
