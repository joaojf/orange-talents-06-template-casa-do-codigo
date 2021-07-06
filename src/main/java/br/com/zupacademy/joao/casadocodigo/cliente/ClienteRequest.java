package br.com.zupacademy.joao.casadocodigo.cliente;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.joao.casadocodigo.config.handler.SeExiste;
import br.com.zupacademy.joao.casadocodigo.config.handler.UniqueValue;
import br.com.zupacademy.joao.casadocodigo.estado.Estado;
import br.com.zupacademy.joao.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.joao.casadocodigo.pais.Pais;
import br.com.zupacademy.joao.casadocodigo.pais.PaisRepository;

@EstadoPais
public class ClienteRequest {

	@NotBlank @Email @UniqueValue(clazz = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank @Documento @UniqueValue(clazz = Cliente.class, fieldName = "documento")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotNull @SeExiste(clazz = Pais.class, fieldName = "id")
	private Long idPais;

	private Long idEstado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public Cliente converte(PaisRepository repositoryPais, EstadoRepository repositoryEstado) {
		Optional<Pais> optionalPais = repositoryPais.findById(idPais);
		Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco,
				this.complemento, this.cidade, optionalPais.get(), this.telefone, this.cep);
		if (idEstado != null) {
			Optional<Estado> optionalEstado = repositoryEstado.findById(idEstado);
			cliente.setEstado(optionalEstado.get());
		}
		return cliente;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

}
