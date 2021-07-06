package br.com.zupacademy.joao.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.joao.casadocodigo.config.handler.Unique;

public class PaisRequest {
	
	@NotBlank
    @Unique(clazz = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais converte() {
        return new Pais(nome);
    }

}
