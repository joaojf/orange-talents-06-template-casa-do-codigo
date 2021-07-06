package br.com.zupacademy.joao.casadocodigo.cliente;

public class ClienteResponse {

	private Long id;

	public Long getId() {
		return id;
	}

	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
	}

}
