package br.com.zupacademy.joao.casadocodigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {
	
	private AutorRepository repositoryAutor;
	
	@Autowired
	public AutorController(AutorRepository repositoryAutor) {
		this.repositoryAutor = repositoryAutor;
	}
	
	@PostMapping(value = "/cadastrar")
	@Transactional
	public ResponseEntity<Autor> cadastrar(@RequestBody @Valid ReceberAutorDto dto) {
		Autor autor = dto.converte();
		repositoryAutor.save(autor);
		return ResponseEntity.ok().build();
	}

}
