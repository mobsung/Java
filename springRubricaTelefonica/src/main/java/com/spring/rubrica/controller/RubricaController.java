package com.spring.rubrica.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.dto.RubricaNomiProprietariTotaleRubricheDTO;
import com.spring.rubrica.dto.RubricaProprietariTotaleContattiDTO;
import com.spring.rubrica.dto.RubricaProprietarioAnnoCreazioneDTO;
import com.spring.rubrica.dto.RubricaProprietarioCreazionePiuVecchiaDTO;
import com.spring.rubrica.service.RubricaService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/rubriche")
public class RubricaController {
	
	RubricaService service = new RubricaService();
	
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
	
}
