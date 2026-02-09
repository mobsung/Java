package com.spring.rubrica.service;

import static com.spring.rubrica.Converti.*;


import com.spring.rubrica.Converti;
import com.spring.rubrica.dao.DAORubrica;
import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.dto.ContattoIdDTO;
import com.spring.rubrica.dto.ContattoModificaPreferito;
import com.spring.rubrica.dto.ContattoNomeCognomeDatoGruppoDTO;
import com.spring.rubrica.entity.Contatto;
import com.spring.rubrica.entity.Rubrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class ContattoService {

	@Autowired
	private DAORubrica dao;

	public boolean insertContatto(int id, ContattoDTO contattoDto){
		Rubrica rubrica = dao.findById(id);
		if (rubrica == null) {
			return false;
		}
		return rubrica.addContatto(ContattoDTOEntity(contattoDto));
	}

	public ContattoDTO selectById(int id, ContattoIdDTO dto){
		Rubrica rubrica = dao.findById(id);
		if (rubrica != null) {
			return rubrica
					.getContatti().stream()
					.filter(c -> c.getNome().equals(dto.getNome()) && c.getCognome().equals(dto.getCognome()))
					.findFirst()
					.map(c -> ContattoEntityDTO(c))
					.orElse(null);
		}
		return null;
	}

	public ContattoDTO modifyContatto(int id, ContattoDTO c){
		Rubrica rubrica = dao.findById(id);
		if (rubrica != null && selectById(id, new ContattoIdDTO(c.getNome(), c.getCognome())) != null){
			Contatto contatto = rubrica.getContatti().stream()
					.filter(co -> co.getNome().equals(c.getNome()) && co.getCognome().equals(c.getCognome()))
					.findFirst()
					.get();
			contatto.setNumero(c.getNumero());
			contatto.setDataNascita(c.getDataNascita());
			contatto.setPreferito(c.isPreferito());
			contatto.setGruppoAppartenenza(c.getGruppoAppartenenza());
			return ContattoEntityDTO(contatto);
		}
		return null;
	}

	public ContattoDTO deleteContatto(int id, ContattoIdDTO dto){
		if (selectById(id, new ContattoIdDTO(dto.getNome(), dto.getCognome())) != null){
			Contatto contatto = ContattoDTOEntity(selectById(id, new ContattoIdDTO(dto.getNome(), dto.getCognome())));
			dao.findById(id).getContatti().remove(contatto);
			return ContattoEntityDTO(contatto);
		}
		return null;
	}

	public List<ContattoDTO> selectAllContatti(int id){
		Rubrica rubrica = dao.findById(id);
		if (rubrica != null){
			return new ArrayList<>(HSContattiEntityDTO(rubrica.getContatti()));
		}
		return new ArrayList<>();
	}

	public int numeroContatti(int id){
		Rubrica rubrica = dao.findById(id);
		if (rubrica != null){
			return rubrica.getContatti().size();
		}
		return 0;
	}

	public ContattoDTO selectContattoByNumero(int id, String numero){
		Rubrica rubrica = dao.findById(id);
		if (rubrica == null) {
			return null;
		}
		return rubrica
				.getContatti().stream()
				.filter(c -> c.getNumero().equals(numero))
				.findFirst()
				.map(c -> ContattoEntityDTO(c))
				.orElse(null);
	}

	public List<ContattoNomeCognomeDatoGruppoDTO> selectContattiPerGruppo(int id, String gruppo){
		Rubrica rubrica = dao.findById(id);
		if (rubrica == null) {
			return new ArrayList<>();
		}
		return dao.findById(id)
				.getContatti().stream()
				.filter(c -> c.getGruppoAppartenenza().equals(gruppo))
				.map(c -> new ContattoNomeCognomeDatoGruppoDTO(c.getNome(), c.getCognome()))
				.toList();
	}

	public int totaleContattiGruppo(int id, String gruppo){
		Rubrica rubrica = dao.findById(id);
		if (rubrica != null) {
			return rubrica
					.getContatti().stream()
					.filter(c -> c.getGruppoAppartenenza().equals(gruppo))
					.toList()
					.size();
			}
		return 0;
	}

	public List<ContattoDTO> cancellaContattiGruppo(int id, String gruppo){
		Rubrica rubrica = dao.findById(id);
		if (rubrica != null){
			List<Contatto> contatti = rubrica
					.getContatti().stream()
					.filter(c -> c.getGruppoAppartenenza().equals(gruppo))
					.toList();
			contatti.forEach(c -> rubrica.getContatti().remove(c));
			return new ArrayList<>(HSContattiEntityDTO((HashSet<Contatto>) contatti));
		}
		return new ArrayList<>();
	}

	public ContattoDTO modifyPreferito(int id, ContattoModificaPreferito dto){
		if (selectById(id, new ContattoIdDTO(dto.getNome(), dto.getCognome())) != null) {
			Contatto contatto = ContattoDTOEntity(selectById(id, new ContattoIdDTO(dto.getNome(), dto.getCognome())));
			contatto.setPreferito(dto.isPreferito());
			return ContattoEntityDTO(contatto);
		}
		return null;
	}

	public List<ContattoDTO> findPreferiti(int id){
		Rubrica rubrica = dao.findById(id);
		if (rubrica == null){
			return null;
		}
		return rubrica.getContatti().stream()
				.filter(Contatto::isPreferito)
				.map(Converti::ContattoEntityDTO)
				.toList();
	}
}
