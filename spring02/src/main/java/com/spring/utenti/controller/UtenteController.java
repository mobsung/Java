package com.spring.utenti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.utenti.entity.Utente;
import com.spring.utenti.service.UtenteService;

@RestController
@RequestMapping(path="/utenti")
public class UtenteController {
	
	private UtenteService service = new UtenteService();
	
	
	@PostMapping(path="/salva", consumes = "application/json")
	public boolean salva(@RequestBody Utente utente) {
		return service.registra(utente);
	}
	
	@GetMapping(path="/visualizza/{idUtente}", produces = "application/json")
	public Utente visualizza(@PathVariable int idUtente) {
		return service.cercaPerId(idUtente);
	}
	
	@GetMapping(path="/visualizza/tutti", produces = "application/json")
	public List<Utente> visualizzaUtenti(){
		return service.selectAll();
	}
	
	@DeleteMapping(path="/delete/{idUtente}", produces = "application/json")
	public Utente rimuovi(@PathVariable int idUtente) {
		return service.delete(idUtente);
	}
	
	@PatchMapping(path="/{idUtente}/newMail", produces = "application/json")
	public Utente updateMail(@PathVariable int idUtente, String newMail) {
		return service.modificaMail(idUtente, newMail);
	}
	
	@GetMapping(path="/nUtenti", produces = "application/json")
	public int getNumeroUtenti() {
		return service.numeroUtenti();
	}
	
	@GetMapping(path="/nomi", produces = "application/json")
	public List<String> cercaNomiUtenti() {
		return service.cercaNomiUtenti();
	}
	
	@GetMapping(path="/nome", produces = "application/json")
	public List<Utente> cercaPerNome(String nome){
		return service.cercaPerNome(nome);
	}
	
	@PostMapping(path="/salva/tutti", consumes = "application/json")
	public boolean insertAll(@RequestBody List<Utente> utenti) {
		return service.insertAll(utenti);
	}
}
