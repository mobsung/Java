package org.spring.impiegati.controller;


import org.spring.impiegati.dto.ImpiegatoDTO;
import org.spring.impiegati.dto.NomeCognomeDTO;
import org.spring.impiegati.service.ImpiegatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path = "/impiegati")
public class ImpiegatoController {

    @Autowired
    ImpiegatoService service;

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void assumi(@RequestBody ImpiegatoDTO dto){
        service.assumi(dto);
    }

    @GetMapping(path = "/{matricola}", produces = "application/json")
    public ImpiegatoDTO cercaPerMatricola(@PathVariable int matricola) {
        return service.cercaPerMatricola(matricola);
    }

    @GetMapping(path = "/all", produces = "application/json")
    public List<ImpiegatoDTO> visualizzaTutti() {
        return service.visualizzaTutti();
    }

    @DeleteMapping(path = "{matricola}", produces = "application/json")
    public ImpiegatoDTO cancellaPerMatricola(@PathVariable int matricola) {
        return service.cancellaPerMatricola(matricola);
    }

    @PatchMapping(path = "/{matricola}", produces = "application/json")
    public ImpiegatoDTO modificaSalario(@PathVariable int matricola, double nuovoSalario) {
        return service.modificaSalario(matricola, nuovoSalario);
    }

    @DeleteMapping(path = "/{matricola}/cnomeCognome", produces = "application/json")
    public NomeCognomeDTO cancellaConNomeCognome(@PathVariable int matricola) {
        return service.cancellaConNomeCognome(matricola);
    }

    @GetMapping(path = "/all/order/matricola", produces = "application/json")
    public List<NomeCognomeDTO> visualizzaOrdinatiMatricola() {
        return service.visualizzaOrdinatiMatricola();
    }

    @GetMapping(path = "/salario/mese", produces = "application/json")
    public double visualizzaTotSalarioMese() {
        return service.visualizzaTotSalarioMese();
    }

    @GetMapping(path = "/all/order/surname", produces = "application/json")
    public List<ImpiegatoDTO> visualizzaOrdinatiCognome() {
        return service.visualizzaOrdinatiCognome();
    }

    @GetMapping(path = "/assunzione/vecchia", produces = "application/json")
    public ImpiegatoDTO visualizzaAssunzionePiuVecchia() {
        return service.visualizzaAssunzionePiuVecchia();
    }

    @GetMapping(path = "/salario/maggiore", produces = "application/json")
    public ImpiegatoDTO visualizzaSalarioMaggioreDatoTempo(LocalDate data) {
        return service.visualizzaSalarioMaggioreDatoTempo(data);
    }

    @GetMapping(path = "/all/order/name", produces = "application/json")
    public List<ImpiegatoDTO> getImpiegatiOrdinatiNome(){
        return service.getImpiegatiOrdinatiNome();
    }

    @GetMapping(path = "/rich", produces = "application/json")
    public List<ImpiegatoDTO> getImpiegatoSalarioMaggiore(){
        return service.getImpiegatoSalarioMaggiore();
    }
}
