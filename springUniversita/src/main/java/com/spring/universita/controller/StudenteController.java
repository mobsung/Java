package com.spring.universita.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.universita.dto.StudenteDTO;
import com.spring.universita.service.StudenteService;

@RestController
@RequestMapping(path="/studenti")
public class StudenteController {
	
	StudenteService service = new StudenteService();
	
	@PostMapping(path="/registra", consumes="application/json")
	public boolean registra(@RequestBody StudenteDTO studente) {
		return service.insert(studente);
	}

}
