package com.bruno.atividade2secao4;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.atividade2secao4.domain.Colecao;
import com.bruno.atividade2secao4.domain.Editora;
import com.bruno.atividade2secao4.domain.Emprestimo;
import com.bruno.atividade2secao4.domain.Genero;
import com.bruno.atividade2secao4.domain.Livro;
import com.bruno.atividade2secao4.domain.Usuario;
import com.bruno.atividade2secao4.repositories.ColecaoRepository;
import com.bruno.atividade2secao4.repositories.EditoraRepository;
import com.bruno.atividade2secao4.repositories.EmprestimoRepository;
import com.bruno.atividade2secao4.repositories.GeneroRepository;
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
	@Autowired
	private EditoraRepository editoraRepository;
	@Autowired
	private GeneroRepository generoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Atividade3secao4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Usuario u1 = new Usuario(null, "Bruno Wellington", "123456", "84986647523", "bruno@gmail.com");
		
		usuarioRepository.saveAll(Arrays.asList(u1));
		
		
		Colecao c1 = new Colecao(null, "Java oficial");
		
		colecaoRepository.saveAll(Arrays.asList(c1));
		
		Editora ed1 = new Editora(null, "Bookman");
		Editora ed2 = new Editora(null, "ISBN-10");
		
		editoraRepository.saveAll(Arrays.asList(ed1, ed2));
		
		Genero g1 = new Genero(null, "Programação");
		Genero g2 = new Genero(null, "Ficção");
		
		generoRepository.saveAllAndFlush(Arrays.asList(g1, g2));
		
		Livro l1 = new Livro(null, "Java Core", 320, 2.00, c1, ed1, g1);
		Livro l2 = new Livro(null, "Python Core", 150, 3.00, null, ed1, g1);
		Livro l3 = new Livro(null, "Deadpool", 200, 2.50, null, ed2, g2);
		
		livroRepository.saveAll(Arrays.asList(l1, l2, l3));
		
		Emprestimo e1 = new Emprestimo(null, sdf.parse("10/06/2024 10:32"), sdf.parse("15/06/2024 14:15"), u1, l1);
		Emprestimo e2 = new Emprestimo(null, sdf.parse("01/07/2024 13:45"), sdf.parse("03/07/2024 21:50"), u1, l3);
		
		emprestimoRepository.saveAll(Arrays.asList(e1, e2));
		
		u1.getEmprestimos().addAll(Arrays.asList(e1, e2));
		
		c1.getLivros().addAll(Arrays.asList(l1));
		
		ed1.getLivros().addAll(Arrays.asList(l1, l2));
		ed2.getLivros().addAll(Arrays.asList(l3));
		
		g1.getLivros().addAll(Arrays.asList(l1, l2));
		g2.getLivros().addAll(Arrays.asList(l3));
		
		

	}

}
