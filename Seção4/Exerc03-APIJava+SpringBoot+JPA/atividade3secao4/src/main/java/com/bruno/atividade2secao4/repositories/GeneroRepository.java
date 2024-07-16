package com.bruno.atividade2secao4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.atividade2secao4.domain.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

}
