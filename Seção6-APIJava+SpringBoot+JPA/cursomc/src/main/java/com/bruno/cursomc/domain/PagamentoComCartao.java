package com.bruno.cursomc.domain;

import java.util.Objects;

import com.bruno.cursomc.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;//nao precisa implementar o Serializable pois a classe ja herda da classe pagamento

	private Integer numeroDeParcelas;
	
	//Construtor
	public PagamentoComCartao() {
	}

	//Construtor para classes que extends
	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
}
