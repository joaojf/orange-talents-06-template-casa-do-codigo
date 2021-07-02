package br.com.zupacademy.joao.casadocodigo.livro;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.joao.casadocodigo.autor.Autor;
import br.com.zupacademy.joao.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.joao.casadocodigo.categoria.Categoria;
import br.com.zupacademy.joao.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.joao.casadocodigo.config.handler.ExistsRegister;
import br.com.zupacademy.joao.casadocodigo.config.handler.UniqueValue;

public class LivroRequest {

	@NotBlank
	@UniqueValue(clazz = Livro.class, fieldName = "titulo")
	private String titulo;

	@NotBlank
	@Length(max = 500)
	private String resumo;

	@NotBlank
	private String sumario;

	@NotNull
	@Min(value = 20)
	private Double price;

	@NotNull
	@Min(value = 100)
	private Integer numPaginas;

	@NotBlank
	@UniqueValue(clazz = Livro.class, fieldName = "isbn")
	private String isbn;

	@NotNull
	@Future
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataPublicacao;

	@ExistsRegister(domainClass = Categoria.class)
	private Long categoriaId;

	@ExistsRegister(domainClass = Autor.class)
	private Long autorId;

	public Livro converte(AutorRepository autorRepositoy, CategoriaRepository categoriaRepositoy) {
		Optional<Autor> optionalAutor = autorRepositoy.findById(autorId);
		Optional<Categoria> optionalCategoria = categoriaRepositoy.findById(categoriaId);
		return new Livro(this.titulo, this.resumo, this.sumario, this.price, this.numPaginas, this.isbn,
				this.dataPublicacao, optionalCategoria.get(), optionalAutor.get());
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

	public Long getCategoriaId() {
		return categoriaId;
	}

	public Long getAutorId() {
		return autorId;
	}

}
