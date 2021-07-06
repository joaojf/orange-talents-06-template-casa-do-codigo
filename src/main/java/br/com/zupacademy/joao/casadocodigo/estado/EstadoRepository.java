package br.com.zupacademy.joao.casadocodigo.estado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	List<Estado> findByPaisId(Long idPais);
	
    Estado findByIdAndPaisId(Long idEstado, Long idPais);

}
