package br.com.zupacademy.joao.casadocodigo.cliente;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joao.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.joao.casadocodigo.pais.PaisRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	private ClienteRepository repositoryCliente;
	private EstadoRepository repositoryEstado;
	private PaisRepository repositoryPais;

	@Autowired
	public ClienteController(ClienteRepository repositoryCliente, EstadoRepository repositoryEstado,
			PaisRepository repositoryPais) {
		this.repositoryCliente = repositoryCliente;
		this.repositoryEstado = repositoryEstado;
		this.repositoryPais = repositoryPais;
	}

	@Transactional
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<ClienteResponse> cadastrar(@Valid @RequestBody ClienteRequest request) {
		Cliente cliente = request.converte(repositoryPais, repositoryEstado);
		repositoryCliente.save(cliente);
		return ResponseEntity.ok(new ClienteResponse(cliente));
	}

}
