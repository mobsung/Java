package com.spring.utenti.service;


import com.spring.utenti.dao.DAOUtenteMappa;
import com.spring.utenti.entity.Utente;

import java.util.List;

public class UtenteService {
	
	private DAOUtenteMappa dao = new DAOUtenteMappa();

	public boolean registra(Utente utente) {
		return dao.insert(utente);
	}
	
	public Utente cercaPerId(int idUtente) {
		return dao.selectById(idUtente);
	}
	
	public List<Utente> selectAll(){
		return dao.selectAll();
	}
	
	public Utente delete(int idUtente) {
		return dao.delete(idUtente);
	}
	
	public Utente modificaMail(int idUtente, String newMail) {
		Utente ut = dao.selectById(idUtente);
		
		if (ut != null) {
			ut.setMail(newMail);
		}
		return ut;
	}
	
	public int numeroUtenti() {
		return dao.selectAll().size();
	}
	
	public List<String> cercaNomiUtenti(){
		return dao.selectAll().stream()
				.map(u -> u.getNome())
				.toList();
	}
	
	public List<Utente> cercaPerNome(String nome){
		return dao.selectAll().stream()
				.filter(u -> u.getNome().equals(nome))
				.toList();
	}
	
	public boolean insertAll(List<Utente> utenti) {
		return dao.insertAll(utenti);
	}
	
}
