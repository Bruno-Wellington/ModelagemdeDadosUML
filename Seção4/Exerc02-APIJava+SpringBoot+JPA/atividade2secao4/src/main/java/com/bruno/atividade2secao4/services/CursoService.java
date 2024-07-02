package com.bruno.atividade2secao4.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.atividade2secao4.domain.Curso;
import com.bruno.atividade2secao4.repositories.CursoRepository;
import com.bruno.atividade2secao4.services.exceptions.ObjectNotFoundException;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso buscar(Integer id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado para o Id: " + id + 
				", Tipo: " + Curso.class.getName()));
	}
}
