package com.spring.rubrica.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring.rubrica.entity.Rubrica;
import com.spring.rubrica.exceptions.IdAlreadyRegisteredException;
import com.spring.rubrica.exceptions.NoIdException;
import org.springframework.stereotype.Repository;

@Repository
public class DAORubricaImpl implements DAORubrica{
	
	Map<Integer, Rubrica> rubriche = new HashMap<>();
	
	public void registra(Rubrica rubrica) {
		if (rubriche.containsKey(rubrica.getId())){
			throw new IdAlreadyRegisteredException("ID: " + rubrica.getId() + " already exists");
		}
		rubriche.put(rubrica.getId(), rubrica);
	}
	
	public void registraTutti(List<Rubrica> rub) {
		rub.forEach(this::registra);
	}
	
	public Rubrica findById(int id) {
		if (rubriche.get(id) == null){
			throw new NoIdException("ID: " + id + "absent");
		}
		return rubriche.get(id);
	}
	
	public List<Rubrica> selectAll(){
		return new ArrayList<>(rubriche.values());
	}
	
	public Rubrica delete(int id) {
		if (rubriche.get(id) == null){
			throw new NoIdException("ID: " + id + "absent");
		}
		return rubriche.remove(id);
	}
	
}
