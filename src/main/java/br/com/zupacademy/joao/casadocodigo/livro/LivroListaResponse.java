package br.com.zupacademy.joao.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroListaResponse {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String nome;
	
	public LivroListaResponse(Livro livro) {
		this.id = livro.getId();
		this.nome = livro.getTitulo();
	}
	
	public static List<LivroListaResponse> converte(List<Livro> livros) {
        return livros.stream().map(livro -> new LivroListaResponse(livro))
                .collect(Collectors.toList());
    }

}
