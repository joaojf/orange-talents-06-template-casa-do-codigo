package br.com.zupacademy.joao.casadocodigo.config.handler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { ExistsRegisterValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsRegister {

	String message() default "Não existe registro relacionado a este identificador unico";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	Class<?> domainClass();

}
