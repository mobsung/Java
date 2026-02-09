package com.spring.rubrica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.rubrica.entity.Rubrica;
import org.springframework.stereotype.Repository;

@Repository
public class DAORubrica {
	
	Map<Integer, Rubrica> rubriche = new HashMap<>();
	
	public boolean registra(Rubrica rubrica) {
		return rubriche.putIfAbsent(rubrica.getId(), rubrica) == null;
	}
	
	public boolean registraTutti(List<Rubrica> rub) {
		rub.forEach(r -> rubriche.putIfAbsent(r.getId(), r));
		return true;
	}
	
	public Rubrica findById(int id) {
		return rubriche.get(id);
	}
	
	public List<Rubrica> selectAll(){
		return new ArrayList<Rubrica>(rubriche.values());
	}
	
	public Rubrica delete(int id) {
		return rubriche.remove(id);
	}
	
}
