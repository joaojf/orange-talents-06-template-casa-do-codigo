package br.com.zupacademy.joao.casadocodigo.categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	private CategoriaRepository repositoryCategoria;
	
	@Autowired
	public CategoriaController(CategoriaRepository repositoryCategoria) {
		this.repositoryCategoria = repositoryCategoria;
	}
	
	@PostMapping(value = "/cadastrar")
	@Transactional
	public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid ReceberCategoriaDto dto) {
		Categoria categoria = dto.converte();
		repositoryCategoria.save(categoria);
		return ResponseEntity.ok().build();
	}

}
