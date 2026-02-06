package com.spring.universita.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.CognomeAnnoIscrizioneStudentePiuTempo;
import com.spring.universita.dto.CognomeNascitaStudenteDTO;
import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.entity.Studente;
import com.spring.universita.service.StudenteService;

@RestController
@RequestMapping(path="/studenti")
public class StudenteController {
	
	StudenteService service = new StudenteService();
	
	@PostMapping(path="/registra", consumes="application/json")
	public boolean registra(@RequestBody StudenteDTO studente) {
		return service.insert(studente);
	}
	
	@GetMapping(path="/getByMat/{matricola}", produces="application/json")
	public Studente getByMat(@PathVariable int matricola) {
		return service.selectByMat(matricola);
	}
	
	@GetMapping(path="/all", produces="application/json")
	public List<Studente> findAll(){
		return service.findAll();
	}
	
	@DeleteMapping(path="/delete/{matricola}", produces="application/json")
	public Studente delete(@PathVariable int matricola) {
		return service.delete(matricola);
	}
	
	@PatchMapping(path="/{matricola}/indirizzo", produces="application/json")
	public Studente modIndirizzo(@PathVariable int matricola, String indirizzo) {
		return service.modIndirizzo(matricola, indirizzo);
	}
	
	@GetMapping(path="/all/names", produces="application/json")
	public List<String> allNames(){
		return service.allNames();
	}
	
	@GetMapping(path="/cognome/nascita", produces="application/json")
	public CognomeNascitaStudenteDTO CognomeNascita() {
		return service.CognomeNascita();
	}
	
	@GetMapping(path="/cognome/iscrizione", produces="application/json")
	public CognomeAnnoIscrizioneStudentePiuTempo CognomeIscrizione() {
		return service.CognomeIscrizione();
	}
}
