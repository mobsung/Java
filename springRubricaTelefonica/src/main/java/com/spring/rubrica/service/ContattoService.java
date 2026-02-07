package com.spring.rubrica.service;

import static com.spring.rubrica.Converti.*;


import com.spring.rubrica.dao.DAORubrica;
import com.spring.rubrica.dto.ContattoDTO;
import com.spring.rubrica.entity.Rubrica;

public class ContattoService {
	
	DAORubrica dao = new DAORubrica();

	public boolean insertContatto(int id, ContattoDTO contatttoDto){
		Rubrica rubrica = dao.findById(id);
		return rubrica.addContatto(ContattoDTOEntity(contatttoDto));
	}
	
	
	
}
