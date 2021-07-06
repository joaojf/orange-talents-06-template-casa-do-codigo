package br.com.zupacademy.joao.casadocodigo.cliente;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.joao.casadocodigo.estado.Estado;
import br.com.zupacademy.joao.casadocodigo.estado.EstadoRepository;

public class EstadoPaisValidator implements ConstraintValidator<EstadoPais, ClienteRequest> {

	@Autowired
	private EstadoRepository repositoryEstado;

	@Override
	public void initialize(EstadoPais constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(ClienteRequest value, ConstraintValidatorContext context) {

		List<Estado> paisTemEstados = repositoryEstado.findByPaisId(value.getIdPais());

		Estado paisTemOestado = repositoryEstado.findByIdAndPaisId(value.getIdEstado(), value.getIdPais());

		if (value.getIdEstado() == null && !paisTemEstados.isEmpty()) {
			return false;
		}

		if (value.getIdEstado() != null && paisTemOestado == null) {
			return false;
		}

		return true;

	}

}
