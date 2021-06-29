package br.com.zupacademy.joao.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidatorEmailAutorDuplicado.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailAutorDuplicado {
	
	String message() default "Email já cadastrado";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
