package com.bruno.atividade2secao4.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.atividade2secao4.domain.Curso;
import com.bruno.atividade2secao4.services.CursoService;

@RestController
@RequestMapping(value="/cursos")
public class CursoResource {

	@Autowired
	private CursoService cursoService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Curso curso = cursoService.buscar(id);
		return ResponseEntity.ok().body(curso);
	}
}
