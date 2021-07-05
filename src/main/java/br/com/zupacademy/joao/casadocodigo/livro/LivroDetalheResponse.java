package br.com.zupacademy.joao.casadocodigo.livro;

import java.time.format.DateTimeFormatter;

import br.com.zupacademy.joao.casadocodigo.autor.AutorResponse;

public class LivroDetalheResponse {

	private String titulo;

	private String resumo;

	private String sumario;

	private Double price;

	private Integer numPaginas;

	private String isbn;

	private String dataPublicacao;

	private AutorResponse autor;

	public LivroDetalheResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.price = livro.getPrice();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.numPaginas = livro.getNumPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.autor = new AutorResponse(livro.getAutor());
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

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public AutorResponse getAutor() {
		return autor;
	}

}
