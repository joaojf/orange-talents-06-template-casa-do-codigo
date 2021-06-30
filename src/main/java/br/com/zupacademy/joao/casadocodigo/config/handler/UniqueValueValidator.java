package br.com.zupacademy.joao.casadocodigo.config.handler;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

	private String fildName;
	private Class<?> clazz;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(UniqueValue constraintAnnotation) {
		fildName = constraintAnnotation.fieldName();
		clazz = constraintAnnotation.clazz();
	};

	private static final Logger LOGGER = LoggerFactory.getLogger(UniqueValueValidator.class);

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String jpql = "SELECT c FROM " + clazz.getName() + " c where c." + fildName + "=:value";
		LOGGER.info(jpql);
		Query query = manager.createQuery(jpql);
		query.setParameter("value", value);
		boolean valido = query.getResultList().isEmpty();
		return valido;
	}

}
