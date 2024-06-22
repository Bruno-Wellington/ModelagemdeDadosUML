package com.bruno.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private int cod;
	private String descricao;
	
	//Construtor
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	//get cod
	public int getCod() {
		return cod;
	}
	
	//get descrição
	public String getDescricao() {
		return descricao;
	}

	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		//Se esgotar o for e nao achar ninguem, indica que era um codigo invalido e retornamos uma exception.
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
}
