package br.com.zupacademy.joao.casadocodigo.autor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {
	Optional<?> findByEmail(String email);

}
