package com.bruno.atividade2secao4.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.atividade2secao4.domain.Livro;
import com.bruno.atividade2secao4.repositories.LivroRepository;
import com.bruno.atividade2secao4.services.exceptions.ObjNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repo;
	
	public Livro find(Integer id) {
		Optional<Livro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
				"Objeto nao encontrado para o id: " + id + ", Tipo: " + Livro.class.getName()));
	}

}
