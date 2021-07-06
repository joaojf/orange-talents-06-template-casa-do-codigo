package br.com.zupacademy.joao.casadocodigo.config.handler;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.joao.casadocodigo.estado.EstadoRequest;

public class EstadoJaExisteNoPaisValidator implements ConstraintValidator<EstadoJaExisteNoPais, EstadoRequest> {
	
	@Autowired
    private EntityManager entityManager;

    @Override
    public void initialize(EstadoJaExisteNoPais constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(EstadoRequest value, ConstraintValidatorContext context) {
        String JPQL = "SELECT e FROM Estado e WHERE e.pais.id = :pIdPais AND e.nome = :pNomeEstado";
        Query query = entityManager.createQuery(JPQL);
        query.setParameter("pIdPais", value.getIdPais());
        query.setParameter("pNomeEstado", value.getNome());
        boolean valido = query.getResultList().isEmpty();
        return valido;
    }

}
