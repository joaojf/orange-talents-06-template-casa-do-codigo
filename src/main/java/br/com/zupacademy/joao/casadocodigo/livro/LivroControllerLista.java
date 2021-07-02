package br.com.zupacademy.joao.casadocodigo.livro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class LivroControllerLista {
	
	private LivroRepository repositoryLivro;
	
	@Autowired
	public LivroControllerLista(LivroRepository repositoryLivro) {
		this.repositoryLivro = repositoryLivro;
	}
	
	@GetMapping
	public ResponseEntity<List<LivroListaResponse>>  listaTodos() {
		List<Livro> livros = repositoryLivro.findAll();
		return ResponseEntity.ok(LivroListaResponse.converte(livros));
	}

}
