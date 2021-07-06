package br.com.zupacademy.joao.casadocodigo.config.handler;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EstadoJaExisteNoPaisValidator.class)

public @interface EstadoJaExisteNoPais {
	String message() default "Estado já cadastrado neste País";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
