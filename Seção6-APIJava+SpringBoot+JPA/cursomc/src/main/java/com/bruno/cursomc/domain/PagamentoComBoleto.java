package com.bruno.cursomc.domain;

import java.util.Date;
import java.util.Objects;

import com.bruno.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;//nao precisa implementar o Serializable pois a classe ja herda da classe pagamento

	@JsonFormat(pattern="dd/MM/yyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyy")
	private Date dataPagamento;
	
	//Construtor
	public PagamentoComBoleto() {
	}

	//Construtor para classes que extends
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
}
