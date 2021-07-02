package br.com.zupacademy.joao.casadocodigo.livro;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.joao.casadocodigo.autor.Autor;
import br.com.zupacademy.joao.casadocodigo.categoria.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String titulo;

	@NotBlank
	@Length(max = 500)
	@Column(nullable = false, length = 500)
	private String resumo;

	@NotBlank
	@Column(nullable = false)
	private String sumario;

	@Min(value = 20)
	@Column(nullable = false)
	private Double price;

	@Min(value = 100)
	@Column(nullable = false)
	private Integer numPaginas;

	@NotBlank
	@Column(nullable = false, unique = true)
	private String isbn;

	@Column(nullable = false)
	private LocalDate dataPublicacao;

	@ManyToOne
	private Categoria categoria;

	@ManyToOne
	private Autor autor;

	public Livro() {}

	public Livro(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) Double price, @Min(100) Integer numPaginas, @NotBlank String isbn, LocalDate dataPublicacao,
			Categoria categoria, Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.price = price;
		this.numPaginas = numPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}

}
