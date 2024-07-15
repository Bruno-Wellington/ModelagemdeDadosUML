package com.bruno.atividade2secao4.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.atividade2secao4.domain.Usuario;
import com.bruno.atividade2secao4.repositories.UsuarioRepository;
import com.bruno.atividade2secao4.services.exceptions.ObjNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjNotFoundException(
				"Objeto nao encontrado para o id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

}
