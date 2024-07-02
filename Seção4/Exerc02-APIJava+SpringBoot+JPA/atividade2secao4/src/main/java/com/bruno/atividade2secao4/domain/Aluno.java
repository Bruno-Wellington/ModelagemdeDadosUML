package com.bruno.atividade2secao4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cpf;
	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyy hh:mm")
	private Date nascimento;
	
	@OneToMany(mappedBy ="id.aluno")
	private Set<Matricula> matriculas = new HashSet<>();
	
	
	@OneToMany(mappedBy = "id.aluno")
	private Set<Resultado> avaliacoes = new HashSet<>();

	public Aluno() {
	}

	public Aluno(Integer id, String cpf, String nome, Date nascimento) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
	}
	
	public List<Avaliacao> getAvaliacao(){
		List<Avaliacao> lista = new ArrayList<>();
		for(Resultado x : avaliacoes) {
			lista.add(x.getAvaliacao());
		}
		return lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void String(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Set<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	@JsonIgnore
	public Set<Resultado> getAvaliacoes() {
		return avaliacoes;
	}
	
	@JsonIgnore
	public void setAvaliacoes(Set<Resultado> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
