package br.com.zupacademy.joao.casadocodigo.estado;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joao.casadocodigo.pais.PaisRepository;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {
	
	private EstadoRepository repositoryEstado;
	private PaisRepository repositoryPais;
	
	@Autowired
	public EstadoController(EstadoRepository repositoryEstado, PaisRepository repositoryPais) {
		this.repositoryEstado = repositoryEstado;
		this.repositoryPais = repositoryPais;
	}
	
	@Transactional
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<?> cadastrarEstado(@Valid @RequestBody EstadoRequest request) {
		Estado estado = request.converte(repositoryPais);
		repositoryEstado.save(estado);
		return ResponseEntity.ok().build();
	}

}
