package org.spring.sc.service;

import org.spring.sc.dao.DAOcalcoli;
import org.spring.sc.dto.OperazioneFrequezaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ReportService {

    @Autowired
    DAOcalcoli dao;

    public OperazioneFrequezaDTO operazioneFrequezaDTO(String operazione){
        return new OperazioneFrequezaDTO(operazione, dao.getById(operazione));
    }

    public Map<String, Integer> reportComplessivo(){
        return dao.selectAll();
    }
}
