package br.com.zupacademy.joao.casadocodigo.cliente;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = EstadoPaisValidator.class)
public @interface EstadoPais {
	
	String message() default "Estado inválido";
	
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};

}
