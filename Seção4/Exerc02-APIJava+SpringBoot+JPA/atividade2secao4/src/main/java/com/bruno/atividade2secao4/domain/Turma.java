package com.bruno.atividade2secao4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date inicio;
	private Integer vagas;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	@JsonIgnore
	@OneToMany(mappedBy ="id.turma")
	private Set<Matricula> turmas = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "turma")
	private List<Avaliacao> avaliacoes = new ArrayList<>();
	
	public Turma() {
	}

	public Turma(Integer id, String nome, Date inicio, Integer vagas, Curso curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.inicio = inicio;
		this.vagas = vagas;
		this.curso = curso;
	}
	
	
	public List<Aluno> getAlunos(){
		List<Aluno> lista = new ArrayList<>();
		for(Matricula x : turmas) {
			lista.add(x.getAluno());
		}
		return lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public Set<Matricula> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Matricula> turmas) {
		this.turmas = turmas;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}

}
