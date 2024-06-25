package com.bruno.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"), 
	QUITADO(2, "Quitado"), 
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String estado;
	
	private EstadoPagamento(int cod, String estado) {
		this.cod = cod;
		this.estado = estado;
	}

	public int getCod() {
		return cod;
	}

	public String getEstado() {
		return estado;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

	
}
