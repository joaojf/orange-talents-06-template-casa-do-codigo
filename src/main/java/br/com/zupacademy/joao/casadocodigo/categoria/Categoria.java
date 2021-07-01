package br.com.zupacademy.joao.casadocodigo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	public Categoria() {}

	@JsonCreator(mode = Mode.PROPERTIES)
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Categoria(Long id) {
        this.id = id;
    }

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
