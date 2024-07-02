package com.bruno.atividade2secao4.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Resultado implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ResultadoPK id = new ResultadoPK();
	
	private Double notaObitida;
	
	public Resultado() {
	}

	public Resultado(Aluno aluno, Avaliacao avaliacao, Double notaObitida) {
		super();
		id.setAluno(aluno);
		id.setAvaliacao(avaliacao);
		this.notaObitida = notaObitida;
	}
	
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public Avaliacao getAvaliacao() {
		return id.getAvaliacao();
	}

	public ResultadoPK getId() {
		return id;
	}

	public void setId(ResultadoPK id) {
		this.id = id;
	}

	public Double getNotaObitida() {
		return notaObitida;
	}

	public void setNotaObitida(Double notaObitida) {
		this.notaObitida = notaObitida;
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
		Resultado other = (Resultado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
