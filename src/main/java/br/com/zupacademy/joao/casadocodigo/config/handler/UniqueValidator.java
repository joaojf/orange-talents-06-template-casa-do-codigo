package br.com.zupacademy.joao.casadocodigo.config.handler;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniqueValidator implements ConstraintValidator<Unique, Object> {

	private String fieldName;
	private Class<?> clazz;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(Unique constraintAnnotation) {
		fieldName = constraintAnnotation.fieldName();
		clazz = constraintAnnotation.clazz();
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(UniqueValidator.class);

	@Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String JPQL = "SELECT c FROM "+ clazz.getName()+" c WHERE c."+fieldName+" = :pId";
        LOGGER.info(JPQL);
        Query query = manager.createQuery(JPQL);
        query.setParameter("pId", value);
        boolean valido = query.getResultList().isEmpty();
        return valido;
    }

}
