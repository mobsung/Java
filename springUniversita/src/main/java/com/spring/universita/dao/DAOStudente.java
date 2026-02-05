package com.spring.universita.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.spring.universita.entity.Studente;

public class DAOStudente {
	
	private Map<Integer, Studente> mappa = new HashMap<>();
	
	public boolean insert(Studente std) {
		if(mappa.containsKey(std.getMatricola()))
			return false;
		
		mappa.put(std.getMatricola(), std);
		return true;
	}
	
	public Studente selectByMat(int matricola) {
		return mappa.get(matricola);
	}
	
	public List<Studente> findAll(){
		return new ArrayList<Studente>(mappa.values());
	}
	
	public Studente delete(int matricola) {
		return mappa.remove(matricola);
	}
	
	

}
