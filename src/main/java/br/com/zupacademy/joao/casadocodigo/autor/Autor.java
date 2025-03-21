package br.com.zupacademy.joao.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, unique = true)
	@Email
	private String email;

	@Column(length = 400)
	private String descricao;

	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime createdAt;

	public Autor() {}

	public Autor(String nome, String email, String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public Autor(Long id) {
        this.id = id;
    }

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}

}
