package br.com.zupacademy.joao.casadocodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.joao.casadocodigo.modelo.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{
	
	List<Autor> findByEmail(String email);

}
