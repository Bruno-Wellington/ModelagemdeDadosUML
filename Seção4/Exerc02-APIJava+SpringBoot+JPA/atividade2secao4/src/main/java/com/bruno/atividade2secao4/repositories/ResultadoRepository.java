package com.bruno.atividade2secao4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.atividade2secao4.domain.Resultado;
import com.bruno.atividade2secao4.domain.ResultadoPK;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, ResultadoPK> {

}
