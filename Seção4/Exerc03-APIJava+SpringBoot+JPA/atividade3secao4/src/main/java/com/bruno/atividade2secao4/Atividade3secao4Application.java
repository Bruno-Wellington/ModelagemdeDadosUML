package com.bruno.atividade2secao4;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.atividade2secao4.domain.Colecao;
import com.bruno.atividade2secao4.domain.Emprestimo;
import com.bruno.atividade2secao4.domain.Livro;
import com.bruno.atividade2secao4.domain.Usuario;
import com.bruno.atividade2secao4.repositories.ColecaoRepository;
import com.bruno.atividade2secao4.repositories.EmprestimoRepository;
import com.bruno.atividade2secao4.repositories.LivroRepository;
import com.bruno.atividade2secao4.repositories.UsuarioRepository;

@SpringBootApplication
public class Atividade3secao4Application implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	@Autowired
	private ColecaoRepository colecaoRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Atividade3secao4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Usuario u1 = new Usuario(null, "Bruno Wellington", "123456", "84986647523", "bruno@gmail.com");
		
		Emprestimo e1 = new Emprestimo(null, sdf.parse("10/06/2024 10:32"), sdf.parse("15/06/2024 14:15"), u1);
		Emprestimo e2 = new Emprestimo(null, sdf.parse("01/07/2024 13:45"), sdf.parse("03/07/2024 21:50"), u1);
		
		u1.getEmprestimos().addAll(Arrays.asList(e1, e2));
		
		usuarioRepository.saveAll(Arrays.asList(u1));
		emprestimoRepository.saveAll(Arrays.asList(e1, e2));
		
		
		Colecao c1 = new Colecao(null, "Java oficial");
		
		Livro l1 = new Livro(null, "Java Core", 320, 2.00,c1);
		Livro l2 = new Livro(null, "Python Core", 150, 3.00, null);
		Livro l3 = new Livro(null, "Deadpool", 200, 2.50, null);
		
		c1.getLivros().addAll(Arrays.asList(l1));
		
		colecaoRepository.saveAll(Arrays.asList(c1));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3));
	}

}
