package br.com.zupacademy.joao.casadocodigo.categoria;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
