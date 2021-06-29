package br.com.zupacademy.joao.casadocodigo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.joao.casadocodigo.modelo.Autor;

public class ReceberAutorDto {

	@NotBlank @Length(min = 3, max = 30)
	private String nome;

	@NotBlank @Length(min = 5, max = 30) @Email
	private String email;

	@NotBlank @Length(max = 400)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Autor converte() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
