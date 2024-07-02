package com.bruno.atividade2secao4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.atividade2secao4.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
