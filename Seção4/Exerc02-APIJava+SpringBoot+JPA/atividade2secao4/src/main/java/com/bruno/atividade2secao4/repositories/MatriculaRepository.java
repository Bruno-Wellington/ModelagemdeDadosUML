package com.bruno.atividade2secao4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.atividade2secao4.domain.Matricula;
import com.bruno.atividade2secao4.domain.MatriculaPK;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaPK> {

}
