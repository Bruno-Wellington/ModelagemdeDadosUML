package com.bruno.atividade2secao4.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
public class Avaliacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double nota;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")
	private Date data;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="turma_id")
	private Turma turma;
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.avaliacao")
	private Set<Resultado> avaliacoes = new HashSet<>();
	
	public Avaliacao() {
	}

	public Avaliacao(Integer id, Double nota, Date data, Turma turma) {
		super();
		this.id = id;
		this.nota = nota;
		this.data = data;
		this.turma = turma;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
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
		Avaliacao other = (Avaliacao) obj;
		return Objects.equals(id, other.id);
	}


	
}
