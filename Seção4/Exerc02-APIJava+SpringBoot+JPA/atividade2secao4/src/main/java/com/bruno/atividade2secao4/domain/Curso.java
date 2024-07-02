package com.bruno.atividade2secao4.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer cargaHoraria;
	private Double valor;
	private Double notaPrevista;
	private Double notaMinima;
	
	@OneToMany(mappedBy = "curso")
	private List<Turma> turmas = new ArrayList<>();
	
	public Curso() {
	}

	public Curso(Integer id, String nome, Integer cargaHoraria, Double valor, Double notaPrevista, Double notaMinima) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.valor = valor;
		this.notaPrevista = notaPrevista;
		this.notaMinima = notaMinima;
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

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getNotaPrevista() {
		return notaPrevista;
	}

	public void setNotaPrevista(Double notaPrevista) {
		this.notaPrevista = notaPrevista;
	}

	public Double getNotaMinima() {
		return notaMinima;
	}

	public void setNotaMinima(Double notaMinima) {
		this.notaMinima = notaMinima;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
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
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
