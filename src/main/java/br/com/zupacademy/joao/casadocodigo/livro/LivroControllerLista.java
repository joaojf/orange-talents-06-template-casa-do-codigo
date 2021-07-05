package br.com.zupacademy.joao.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joao.casadocodigo.config.handler.ObjectNotFoundException;



@RestController
@RequestMapping(value = "/livros")
public class LivroControllerLista {

	private LivroRepository repositoryLivro;

	@Autowired
	public LivroControllerLista(LivroRepository repositoryLivro) {
		this.repositoryLivro = repositoryLivro;
	}

	@GetMapping
	public ResponseEntity<List<LivroListaResponse>> listaTodos() {
		List<Livro> livros = repositoryLivro.findAll();
		return ResponseEntity.ok(LivroListaResponse.converte(livros));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<LivroDetalheResponse> listarDetalhes(@PathVariable Long id) {
		Optional<Livro> optionalLivro = repositoryLivro.findById(id);
		Livro livro = optionalLivro.orElseThrow(() -> new ObjectNotFoundException("Livro com o identificador " + id + " não encontrado"));
		return ResponseEntity.ok(new LivroDetalheResponse(livro));
	}

}
