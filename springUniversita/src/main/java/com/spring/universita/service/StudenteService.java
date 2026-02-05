package com.spring.universita.service;

import java.util.List;
import java.util.Optional;

import com.spring.universita.dao.DAOStudente;
import com.spring.universita.dto.CognomeAnnoIscrizioneStudentePiuTempo;
import com.spring.universita.dto.CognomeNascitaStudenteDTO;
import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.entity.Studente;

public class StudenteService {
	
	DAOStudente dao = new DAOStudente();
	
	public boolean insert(StudenteDTO dto) {
		return dao.insert(new Studente(dto));
	}
	
	public Studente selectByMat(int matricola) {
		return dao.selectByMat(matricola);
	}
	
	public List<Studente> findAll(){
		return dao.findAll();
	}
	
	public Studente delete(int matricola) {
		return dao.delete(matricola);
	}
	
	public Studente modIndirizzo(int matricola, String indirizzo) {
		Studente stud = dao.selectByMat(matricola);
		stud.setIndirizzo(indirizzo);
		return stud;
	}
	
	public List<String> allNames(){
		return dao.findAll().stream()
				.map(s -> s.getNome())
				.toList();
	}
	
	public CognomeNascitaStudenteDTO CognomeNascita() {
		Optional<Studente> opt = dao.findAll().stream()
				.max((s1, s2) -> s1.getAnno_nascita().compareTo(s2.getAnno_nascita()));
		
		return new CognomeNascitaStudenteDTO(opt.get().getCognome(), opt.get().getAnno_nascita());
	}
	
	public CognomeAnnoIscrizioneStudentePiuTempo CognomeIscrizione() {
		Optional<Studente> opt = dao.findAll().stream()
				.min((s1, s2) -> s1.getAnno_immatricolazione().compareTo(s2.getAnno_immatricolazione()));
		
		return new CognomeAnnoIscrizioneStudentePiuTempo(opt.get().getCognome(), opt.get().getAnno_immatricolazione());
	}

}
