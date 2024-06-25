package com.bruno.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	//relação 1 x * no lado do estado
	//1 estado tem varias cidades, logo teremos uma lista de cidades, entao estanciamos dessa forma abaixo
	@JsonBackReference
	@OneToMany(mappedBy="estado")//Mapeamento do atributo estado da tabela cidade
	private List<Cidade> cidades = new ArrayList<>();
	
	//construtor vazio
	public Estado() {
	}

	//construtor
	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	//get e set id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//get e set nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//get e set cidades
	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	//hashCode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
