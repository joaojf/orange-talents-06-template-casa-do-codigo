package br.com.zupacademy.joao.casadocodigo.pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {
	
	private PaisRepository repositoryPais;
	
	@Autowired
	public PaisController(PaisRepository repositoryPais) {
		this.repositoryPais = repositoryPais;
	}
	
	@Transactional
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<?> cadastrarPais(@Valid @RequestBody PaisRequest request) {
		Pais pais = request.converte();
		repositoryPais.save(pais);
		return ResponseEntity.ok().build();
	}

}
