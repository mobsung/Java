package com.spring.rubrica.service;

import static com.spring.rubrica.Converti.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.spring.rubrica.dao.DAORubrica;
import com.spring.rubrica.dto.RubricaDTO;
import com.spring.rubrica.dto.RubricaNomiProprietariTotaleRubricheDTO;
import com.spring.rubrica.dto.RubricaProprietariTotaleContattiDTO;
import com.spring.rubrica.dto.RubricaProprietarioAnnoCreazioneDTO;
import com.spring.rubrica.dto.RubricaProprietarioCreazionePiuVecchiaDTO;
import com.spring.rubrica.entity.Rubrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RubricaService {

	@Autowired
	private DAORubrica dao;

	public boolean insert(RubricaDTO dto) {
		return dao.registra(RubricaDTOEntity(dto));
	}
	
	public boolean insertAll(List<RubricaDTO> rubricheDTO) {
		return dao.registraTutti(ALRubricaDTOEntity(rubricheDTO));
	}
	
	public RubricaDTO selectById(int id) {
		return RubricaEntityDTO(dao.findById(id));
	}
	
	public List<RubricaDTO> selectAll(){
		return ALRubricaEntityDTO(dao.selectAll());	
	}
	
	public RubricaDTO delete(int id) {
		return RubricaEntityDTO(dao.delete(id));
	}
	
	public RubricaProprietarioAnnoCreazioneDTO proprietarioAnnoCreazione(int id) {
		Rubrica rubrica =  dao.findById(id);
		return new RubricaProprietarioAnnoCreazioneDTO(rubrica.getProprietario(), rubrica.getAnnoCreazione());
	}
	
	public RubricaDTO modifyProprietario(int id, String proprietario) {
		Rubrica rubrica = dao.findById(id);
		rubrica.setProprietario(proprietario);
		return RubricaEntityDTO(rubrica);
	}
	
	public RubricaDTO modifyAnnoCreazione(int id, LocalDate annoCreazione) {
		Rubrica rubrica = dao.findById(id);
		rubrica.setAnnoCreazione(annoCreazione);
		return RubricaEntityDTO(rubrica);
	}
	
	public RubricaNomiProprietariTotaleRubricheDTO nomiTotaleProprietari(){
		List<String> proprietari = dao.selectAll().stream()
				.map(r -> r.getProprietario())
				.toList();
		return new RubricaNomiProprietariTotaleRubricheDTO(proprietari, proprietari.size());
	}
	
	public RubricaProprietarioCreazionePiuVecchiaDTO nomiCreazionePiuVecchia() {
		Optional<Rubrica> obj = dao.selectAll().stream()
				.min((r1, r2) -> r1.getAnnoCreazione().compareTo(r2.getAnnoCreazione()));
		return new RubricaProprietarioCreazionePiuVecchiaDTO(obj.get().getProprietario(), obj.get().getAnnoCreazione());
	}
	
	public List<LocalDate> anniCreazioneAsc(){
		return dao.selectAll().stream()
				.map(r -> r.getAnnoCreazione())
				.sorted((r1, r2) -> r1.compareTo(r2))
				.toList();
	}
	
	public RubricaProprietariTotaleContattiDTO propritariTotContatti(int id) {
		Rubrica rubrica = dao.findById(id);
		return new RubricaProprietariTotaleContattiDTO(rubrica.getProprietario(), rubrica.getContatti().size());
	}
}
