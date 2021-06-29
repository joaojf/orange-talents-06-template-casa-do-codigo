package br.com.zupacademy.joao.casadocodigo.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.joao.casadocodigo.dto.ReceberAutorDto;
import br.com.zupacademy.joao.casadocodigo.modelo.Autor;
import br.com.zupacademy.joao.casadocodigo.repository.AutorRepository;

public class ValidatorEmailAutorDuplicado implements ConstraintValidator<EmailAutorDuplicado, ReceberAutorDto> {

	@Autowired
	AutorRepository repository;

	@Override
	public void initialize(EmailAutorDuplicado constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(ReceberAutorDto autor, ConstraintValidatorContext context) {
		List<Autor> listaAutor = this.repository.findByEmail(autor.getEmail());
		return listaAutor.isEmpty();
	}

}
