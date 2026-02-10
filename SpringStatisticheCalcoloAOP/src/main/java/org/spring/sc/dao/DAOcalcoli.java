package org.spring.sc.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DAOcalcoli {

    Map<String, Integer> frequenza = new HashMap<>();

    public void aumenta(String operazione){
        if (frequenza.containsKey(operazione))
            frequenza.replace(operazione, frequenza.get(operazione) + 1);
        else
            frequenza.put(operazione, 1);
    }

    public int getById(String operazione){
        return frequenza.get(operazione);
    }

    public Map<String, Integer> selectAll(){
        return frequenza;
    }
}
