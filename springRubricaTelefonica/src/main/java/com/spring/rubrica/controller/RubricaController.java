package com.spring.rubrica.controller;

import com.spring.rubrica.dto.*;
import com.spring.rubrica.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rubrica.service.RubricaService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/rubriche")
public class RubricaController {

	@Autowired
	RubricaService service;

	@Autowired
	ContattoService serviceContatto;
	
	@PostMapping(path="/insert", consumes="application/json")
	public boolean insert(@RequestBody RubricaDTO Rdto) {
		return service.insert(Rdto);
	}
	
	@PostMapping(path="insert/all", consumes="application/json")
	public boolean insertAll(@RequestBody List<RubricaDTO> LRdto) {
		return service.insertAll(LRdto);
	}
	
	@GetMapping(path="/{id}", produces="application/json")
	public RubricaDTO selectById(@PathVariable int id) {
		return service.selectById(id);
	}
	
	@GetMapping(path="/all", produces="application/json")
	public List<RubricaDTO> selectAll(){
		return service.selectAll();
	}
	
	@DeleteMapping(path="/delete/{id}", produces="application/json")
	public RubricaDTO delete(@PathVariable int id) {
		return service.delete(id);
	}
	
	@GetMapping(path="/{id}/annoCreazione", produces="application/json")
	public RubricaProprietarioAnnoCreazioneDTO proprietarioAnnoCreazione(@PathVariable int id) {
		return service.proprietarioAnnoCreazione(id);
	}
	
	@PatchMapping(path="/modify/{id}/proprietario", produces="application/json")
	public RubricaDTO modifyProprietario(@PathVariable int id, String proprietario) {
		return service.modifyProprietario(id, proprietario);
	}
	
	@PatchMapping(path="/modify/{id}/annoCreazione", produces="application/json")
	public RubricaDTO modifyAnnoCreazione(@PathVariable int id, LocalDate annoCreazione) {
		return service.modifyAnnoCreazione(id, annoCreazione);
	}
	
	@GetMapping(path="/totale/proprietari", produces="application/json")
	public RubricaNomiProprietariTotaleRubricheDTO nomiTotaleProprietari() {
		return service.nomiTotaleProprietari();
	}
	
	@GetMapping(path="/piuVecchia", produces="application/json")
	public RubricaProprietarioCreazionePiuVecchiaDTO nomiCreazionePiuVecchia() {
		return service.nomiCreazionePiuVecchia();
	}
	
	@GetMapping(path="/anniCreazione/asc")
	public List<LocalDate> anniCreazioneAsc(){
		return service.anniCreazioneAsc();
	}
	
	@GetMapping(path="/{id}/totale/contatti", produces="application/json")
	public RubricaProprietariTotaleContattiDTO propritariTotContatti(@PathVariable int id) {
		return service.propritariTotContatti(id);
	}

	@PostMapping(path="/{id}/contatto", consumes="application/json")
	public boolean insertContatto(@PathVariable int id, @RequestBody ContattoDTO dto){
		return serviceContatto.insertContatto(id, dto);
	}

	@GetMapping(path="/{id}/contatto", produces="application/json", consumes="application/json")
	public ContattoDTO selectById(@PathVariable int id, @RequestBody ContattoIdDTO dto){
		return serviceContatto.selectById(id, dto);
	}

	@PatchMapping(path="/{id}/contatto/modify", produces="application/json", consumes="application/json")
	public ContattoDTO modifyContatto(@PathVariable int id, @RequestBody ContattoDTO dto){
		return serviceContatto.modifyContatto(id, dto);
	}

	@DeleteMapping(path="/{id}/contatto/delete", produces="application/json", consumes="application/json")
	public ContattoDTO deleteContatto(@PathVariable int id, @RequestBody ContattoIdDTO dto){
		return serviceContatto.deleteContatto(id, dto);
	}

	@GetMapping(path="/{id}/contatto/all", produces="application/json")
	public List<ContattoDTO> selectAllContatti(@PathVariable int id){
		return serviceContatto.selectAllContatti(id);
	}

	@GetMapping(path="/{id}/contatto/count", produces="application/json")
	public int numeroContatti(@PathVariable int id){
		return serviceContatto.numeroContatti(id);
	}

	@GetMapping(path="/{id}/contatto/numero", produces="application/json")
	public ContattoDTO selectContattoByNumero(@PathVariable int id, String numero){
		return serviceContatto.selectContattoByNumero(id, numero);
	}

	@GetMapping(path="/{id}/contatto/gruppo", produces="application/json")
	public List<ContattoNomeCognomeDatoGruppoDTO> selectContattiPerGruppo(@PathVariable int id, String gruppo){
		return serviceContatto.selectContattiPerGruppo(id, gruppo);
	}

	@GetMapping(path="/{id}/contatto/gruppo/totale", produces="application/json")
	public int totaleContattiGruppo(@PathVariable int id, String gruppo){
		return serviceContatto.totaleContattiGruppo(id, gruppo);
	}

	@GetMapping(path="/{id}/contatto/delete/totale", produces="application/json")
	public List<ContattoDTO> cancellaContattiGruppo(@PathVariable int id, String gruppo){
		return serviceContatto.cancellaContattiGruppo(id, gruppo);
	}

	@PatchMapping(path="/{id}/contatto/modify/preferito", produces="application/json", consumes="application/json")
	public ContattoDTO modifyPreferito(@PathVariable int id, @RequestBody ContattoModificaPreferito dto){
		return serviceContatto.modifyPreferito(id, dto);
	}

	@GetMapping(path="/{id}/contatto/preferito/all", produces="application/json")
	public List<ContattoDTO> findPreferiti(@PathVariable int id){
		return serviceContatto.findPreferiti(id);
	}


}
