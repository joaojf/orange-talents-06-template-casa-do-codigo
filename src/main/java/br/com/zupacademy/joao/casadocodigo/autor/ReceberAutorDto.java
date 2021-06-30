package br.com.zupacademy.joao.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.joao.casadocodigo.autor.validacao.EmailAutorDuplicado;

@EmailAutorDuplicado
public class ReceberAutorDto {

	@NotBlank
	@Length(min = 3, max = 30)
	private String nome;

	@NotBlank
	@Length(min = 5, max = 30)
	@Email
	private String email;

	@NotBlank
	@Length(max = 400)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public Autor converte() {
		return new Autor(this.nome, this.email, this.descricao);
	}

}
