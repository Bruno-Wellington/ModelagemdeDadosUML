package com.bruno.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.cursomc.domain.Categoria;
import com.bruno.cursomc.repositories.CategoriaRepository;
import com.bruno.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo; //Dependencia
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado para o id: " + id +
				", Tipo: " + Categoria.class.getName()));
	}
}
