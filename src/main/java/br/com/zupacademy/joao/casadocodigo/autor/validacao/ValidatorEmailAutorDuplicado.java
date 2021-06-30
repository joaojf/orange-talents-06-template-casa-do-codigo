package br.com.zupacademy.joao.casadocodigo.autor.validacao;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.joao.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.joao.casadocodigo.autor.ReceberAutorDto;

public class ValidatorEmailAutorDuplicado implements
		ConstraintValidator<EmailAutorDuplicado, ReceberAutorDto> {

	@Autowired
	AutorRepository repository;

	@Override
	public void initialize(EmailAutorDuplicado constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
    public boolean isValid(ReceberAutorDto autor, ConstraintValidatorContext context) {
        Optional<?> listaAutor = this.repository.findByEmail(autor.getEmail());
        return listaAutor.isEmpty();
    }

}
