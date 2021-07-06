package br.com.zupacademy.joao.casadocodigo.estado;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.joao.casadocodigo.config.handler.EstadoJaExisteNoPais;
import br.com.zupacademy.joao.casadocodigo.config.handler.ObjectNotFoundException;
import br.com.zupacademy.joao.casadocodigo.config.handler.SeExiste;
import br.com.zupacademy.joao.casadocodigo.pais.Pais;
import br.com.zupacademy.joao.casadocodigo.pais.PaisRepository;

@EstadoJaExisteNoPais
public class EstadoRequest {

	@NotBlank
	private String nome;

	@NotNull
	@SeExiste(clazz = Pais.class, fieldName = "id")
	private Long idPais;

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Estado converte(PaisRepository paisRepository) {
		Optional<Pais> optionalPais = paisRepository.findById(this.idPais);
		Pais pais = optionalPais.orElseThrow(() -> new ObjectNotFoundException("Objeto País não encontrado"));
		return new Estado(nome, pais);
	}

}
