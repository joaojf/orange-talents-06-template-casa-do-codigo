package br.com.zupacademy.joao.casadocodigo.categoria.validacao;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValorUnicoValidator implements
	ConstraintValidator<NomeCategoriaDuplicado, Object> {
	
	private EntityManager em;

	private Class<?> object;
	private String field;
	
	public ValorUnicoValidator(EntityManager em) {
		this.em = em;
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return this.em.createQuery("select 1 from " + this.object.getName() + " where " + field + "=:field")
				.setParameter("field", value).getResultList().isEmpty();
	}
	
	@Override
	public void initialize(NomeCategoriaDuplicado constraintAnnotation) {
		this.object = constraintAnnotation.instacerClass();
		this.field = constraintAnnotation.field();
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

}
