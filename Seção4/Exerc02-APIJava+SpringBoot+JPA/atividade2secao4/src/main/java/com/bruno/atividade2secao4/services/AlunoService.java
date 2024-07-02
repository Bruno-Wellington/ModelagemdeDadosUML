package com.bruno.atividade2secao4.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.atividade2secao4.domain.Aluno;
import com.bruno.atividade2secao4.repositories.AlunoRepository;
import com.bruno.atividade2secao4.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno buscar(Integer id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado para o Id: " + id + 
				", Tipo: " + Aluno.class.getName()));
	}
}
