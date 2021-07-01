package br.com.zupacademy.joao.casadocodigo.livro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joao.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.joao.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	private LivroRepository repositoryLivro;
	private CategoriaRepository repositoryCategoria;
	private AutorRepository repositoryAutor;
	
	public LivroController(LivroRepository repositoryLivro, CategoriaRepository repositoryCategoria,
			AutorRepository repositoryAutor) {
		this.repositoryLivro = repositoryLivro;
		this.repositoryCategoria = repositoryCategoria;
		this.repositoryAutor = repositoryAutor;
	}
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<?> criar(@Valid @RequestBody LivroRequest request) {
		Livro livro = request.converte(repositoryAutor, repositoryCategoria);
		repositoryLivro.save(livro);
		return ResponseEntity.ok().build();
	}

}
