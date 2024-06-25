package com.bruno.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.cursomc.domain.Pedido;
import com.bruno.cursomc.repositories.PedidoRepository;
import com.bruno.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo; //Dependencia
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado para o id: " + id +
				", Tipo: " + Pedido.class.getName()));
	}
}
