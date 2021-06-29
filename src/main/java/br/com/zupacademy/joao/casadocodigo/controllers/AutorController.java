package br.com.zupacademy.joao.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.joao.casadocodigo.dto.ReceberAutorDto;
import br.com.zupacademy.joao.casadocodigo.modelo.Autor;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value = "/cadastrar")
	@Transactional
	public ResponseEntity<Autor> cadastrar(@RequestBody @Valid ReceberAutorDto dto) {
		Autor autor = dto.converte();
		manager.persist(autor);
		return ResponseEntity.ok(autor);
	}

}
