package br.com.zupacademy.joao.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import br.com.zupacademy.joao.casadocodigo.categoria.validacao.NomeCategoriaDuplicado;

public class ReceberCategoriaDto {

	@NotBlank
	@NomeCategoriaDuplicado(instacerClass = Categoria.class, field = "nome")
	private String nome;

	@JsonCreator(mode = Mode.PROPERTIES)
	public ReceberCategoriaDto(@NotBlank String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria converte() {
		return new Categoria(this.nome);
	}

}
