package br.com.zupacademy.joao.casadocodigo.config.handler;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistsRegisterValidator implements ConstraintValidator<ExistsRegister, Object> {

	private Class<?> clazz;
	private final EntityManager em;

	@Autowired
	public ExistsRegisterValidator(EntityManager em) {
		this.em = em;
	}

	@Override
	public void initialize(ExistsRegister params) {
		this.clazz = params.domainClass();
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UniqueValueValidator.class);

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
		String jpql = "select e from " + clazz.getName() + " e where e.id =:element";
		Query query = em.createQuery(jpql);
		LOGGER.info(jpql);
		query.setParameter("element", o);
		List<?> register = query.getResultList();
		if (register.isEmpty()) {
			return false;
		}
		return register.size() == 1;
	}

}
