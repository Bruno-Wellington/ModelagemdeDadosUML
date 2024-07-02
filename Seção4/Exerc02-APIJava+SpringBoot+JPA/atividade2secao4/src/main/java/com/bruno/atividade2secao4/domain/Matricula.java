package com.bruno.atividade2secao4.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private MatriculaPK id = new MatriculaPK();//Va na classe MatriculaPK e coloque a anotação @Embeddable
	
	@JsonFormat(pattern = "dd/MM/yyy hh:mm")
	private Date dataMatricula;
	private Integer numPrestacoes;
	
	public Matricula() {
	}

	public Matricula(Aluno aluno, Turma turma, Date dataMatricula, Integer numPrestacoes) {
		super();
		id.setAluno(aluno);
		id.setTurma(turma);
		this.dataMatricula = dataMatricula;
		this.numPrestacoes = numPrestacoes;
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	@JsonIgnore
	public Turma getTurma() {
		return id.getTurma();
	}

	public MatriculaPK getId() {
		return id;
	}

	public void setId(MatriculaPK id) {
		this.id = id;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Integer getNumPrestacoes() {
		return numPrestacoes;
	}

	public void setNumPrestacoes(Integer numPrestacoes) {
		this.numPrestacoes = numPrestacoes;
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
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
