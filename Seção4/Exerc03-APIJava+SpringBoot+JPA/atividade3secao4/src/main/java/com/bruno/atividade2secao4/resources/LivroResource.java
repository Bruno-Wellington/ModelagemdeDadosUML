package com.bruno.atividade2secao4.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.atividade2secao4.domain.Livro;
import com.bruno.atividade2secao4.services.LivroService;

@RestController
@RequestMapping(value="/livros")
public class LivroResource {

	@Autowired
	private LivroService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Livro obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}
