package org.spring.sc.controller;

import org.spring.sc.dto.OperazioneFrequezaDTO;
import org.spring.sc.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path="/stats", produces = "application/json")
public class StatisticsController {

    @Autowired
    ReportService service;

    @GetMapping(path="/{operazione}")
    public OperazioneFrequezaDTO operazioneFrequezaDTO(@PathVariable String operazione){
        return service.operazioneFrequezaDTO(operazione);
    }

    @GetMapping(path = "/all")
    public Map<String, Integer> reportComplessivo(){
        return service.reportComplessivo();
    }
}
