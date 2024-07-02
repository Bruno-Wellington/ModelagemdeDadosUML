package com.bruno.atividade2secao4;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.atividade2secao4.domain.Aluno;
import com.bruno.atividade2secao4.domain.Avaliacao;
import com.bruno.atividade2secao4.domain.Curso;
import com.bruno.atividade2secao4.domain.Matricula;
import com.bruno.atividade2secao4.domain.Resultado;
import com.bruno.atividade2secao4.domain.Turma;
import com.bruno.atividade2secao4.repositories.AlunoRepository;
import com.bruno.atividade2secao4.repositories.AvaliacaoRepository;
import com.bruno.atividade2secao4.repositories.CursoRepository;
import com.bruno.atividade2secao4.repositories.MatriculaRepository;
import com.bruno.atividade2secao4.repositories.ResultadoRepository;
import com.bruno.atividade2secao4.repositories.TurmaRepository;

@SpringBootApplication
public class Atividade2secao4Application implements CommandLineRunner {
	
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired 
	private TurmaRepository turmaRepository;
	@Autowired 
	private AvaliacaoRepository avaliacaoRepository;
	@Autowired 
	private AlunoRepository alunoRepository;
	@Autowired 
	private MatriculaRepository matriculaRepository;
	@Autowired 
	private ResultadoRepository resultadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Atividade2secao4Application.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		//Mascara para formatar uma data.
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Curso c1 = new Curso(null, "Java com Spring Boot", 80, 200.0, 100.0, 65.0);
		
		Turma t1 = new Turma(null, "A1", sdf.parse("01/06/2024 16:07"), 25, c1);
		
		c1.getTurmas().addAll(Arrays.asList(t1));
		
		cursoRepository.saveAll(Arrays.asList(c1));
		turmaRepository.saveAll(Arrays.asList(t1));
		
		
		
		Avaliacao av1 = new Avaliacao(null, 40.0, sdf.parse("05/06/2024 10:55"), t1);
		Avaliacao av2 = new Avaliacao(null, 60.0, sdf.parse("06/06/2024 18:30"), t1);
		
		t1.getAvaliacoes().addAll(Arrays.asList(av1, av2));

		avaliacaoRepository.saveAll(Arrays.asList(av1, av2));

		
		
		Aluno a1 = new Aluno(null,"78434618675", "Bruno", sdf.parse("05/02/1994 15:52"));
		Aluno a2 = new Aluno(null,"78421619655","Suan", sdf.parse("01/07/1991 23:44"));
		
		Matricula m1 = new Matricula(a1, t1, sdf.parse("15/05/2024 16:08"), 6);
		Matricula m2 = new Matricula(a2, t1, sdf.parse("26/05/2024 12:53"), 4);
		
		t1.getTurmas().addAll(Arrays.asList(m1, m2));
	
		a1.getMatriculas().addAll(Arrays.asList(m1));
		a2.getMatriculas().addAll(Arrays.asList(m2));
		
		alunoRepository.saveAll(Arrays.asList(a1, a2));
		matriculaRepository.saveAll(Arrays.asList(m1, m2));
		
		Resultado r1 = new Resultado(a1, av1, 55.0);
		Resultado r2 = new Resultado(a2, av1, 75.0);
		Resultado r3 = new Resultado(a1, av2, 80.0);
		Resultado r4 = new Resultado(a2, av2, 95.0);
		
		a1.getAvaliacoes().addAll(Arrays.asList(r1,r3));
		a2.getAvaliacoes().addAll(Arrays.asList(r2,r4));
		
		av1.getAvaliacoes().addAll(Arrays.asList(r1, r2));
		av2.getAvaliacoes().addAll(Arrays.asList(r3, r4));
		
		resultadoRepository.saveAll(Arrays.asList(r1, r2, r3, r4));

		
	}

}
