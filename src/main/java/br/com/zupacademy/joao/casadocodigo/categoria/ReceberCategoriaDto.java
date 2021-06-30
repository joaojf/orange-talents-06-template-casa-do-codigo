package br.com.zupacademy.joao.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.joao.casadocodigo.config.handler.UniqueValue;

public class ReceberCategoriaDto {

	@NotBlank
	@UniqueValue(clazz = Categoria.class, fieldName = "nome", message = "Categoria já existe!")
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
