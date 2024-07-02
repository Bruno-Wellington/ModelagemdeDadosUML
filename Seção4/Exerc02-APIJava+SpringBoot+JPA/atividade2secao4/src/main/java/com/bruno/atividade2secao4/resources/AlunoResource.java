package com.bruno.atividade2secao4.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.atividade2secao4.domain.Aluno;
import com.bruno.atividade2secao4.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Aluno aluno = alunoService.buscar(id);
		return ResponseEntity.ok().body(aluno);
	}
}
