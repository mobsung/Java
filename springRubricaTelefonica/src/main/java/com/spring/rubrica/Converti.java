package com.spring.rubrica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;

public class Converti {
	
	public static Contatto ContattoDTOEntity(ContattoDTO dto) {
		Contatto contatto = new Contatto();
		contatto.setNome(dto.getNome());
		contatto.setCognome(dto.getCognome());
		contatto.setDataNascita(dto.getDataNascita());
		contatto.setGruppoAppartenenza(dto.getGruppoAppartenenza());
		contatto.setNumero(dto.getNumero());
		contatto.setPreferito(dto.isPreferito());
		
		return contatto;
		
	}
	
	public static ContattoDTO ContattoEntityDTO(Contatto contatto) {
		ContattoDTO dto = new ContattoDTO();
		dto.setNome(contatto.getNome());
		dto.setCognome(contatto.getCognome());
		dto.setDataNascita(contatto.getDataNascita());
		dto.setGruppoAppartenenza(contatto.getGruppoAppartenenza());
		dto.setNumero(contatto.getNumero());
		dto.setPreferito(contatto.isPreferito());
		
		return dto;
	}
	
	public static HashSet<Contatto> HSContattiDTOEntity(HashSet<ContattoDTO> dto) {
		HashSet<Contatto> contatti = new HashSet<>();
		dto.forEach(c -> contatti.add(ContattoDTOEntity(c)));
		return contatti;
	}
	
	public static HashSet<ContattoDTO> HSContattiEntityDTO(HashSet<Contatto> contatti) {
		HashSet<ContattoDTO> dto = new HashSet<>();
		contatti.forEach(c -> dto.add(ContattoEntityDTO(c)));
		return dto;
	}
	
	public static Rubrica RubricaDTOEntity(RubricaDTO dto) {
		
		Rubrica rubrica = new Rubrica();
		rubrica.setAnnoCreazione(dto.getAnnoCreazione());
		rubrica.setProprietario(dto.getProprietario());
		rubrica.setId(dto.getId());
		rubrica.setContatti(HSContattiDTOEntity(dto.getContatti()));
		
		return rubrica;
	}
	
	public static RubricaDTO RubricaEntityDTO(Rubrica rubrica) {
		
		RubricaDTO dto = new RubricaDTO();
		dto.setAnnoCreazione(rubrica.getAnnoCreazione());
		dto.setProprietario(rubrica.getProprietario());
		dto.setId(rubrica.getId());
		dto.setContatti(HSContattiEntityDTO(rubrica.getContatti()));
		
		return dto;
	}
	
	public static List<Rubrica> ALRubricaDTOEntity(List<RubricaDTO> dto) {
		List<Rubrica> rubriche = new ArrayList<>();
		dto.forEach(r -> rubriche.add(RubricaDTOEntity(r)));
		return rubriche;
	}
	
	public static List<RubricaDTO> ALRubricaEntityDTO(List<Rubrica> rubriche) {
		List<RubricaDTO> dto = new ArrayList<>();
		rubriche.forEach(r -> dto.add(RubricaEntityDTO(r)));
		return dto;
	}
}
