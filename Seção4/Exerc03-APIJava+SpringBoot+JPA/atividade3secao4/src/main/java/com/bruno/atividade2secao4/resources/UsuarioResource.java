package com.bruno.atividade2secao4.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.atividade2secao4.domain.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> listar() {
		
		Usuario u1 = new Usuario(1, "Bruno", "123456", "96523369", "bruno@gmail.com");
		List<Usuario> lista = new ArrayList<>();
		lista.add(u1);
		return lista;
	}
}
