package br.com.zupacademy.joao.casadocodigo.config.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public List<ErroPadrao> handle(MethodArgumentNotValidException exception) {

		List<ErroPadrao> listaErrosPadraos = new ArrayList<>();

		List<FieldError> listFieldErrors = exception.getFieldErrors();
		listFieldErrors.forEach(fieldError -> {
			String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			ErroPadrao erroPadrao = new ErroPadrao(fieldError.getField(), mensagem);
			listaErrosPadraos.add(erroPadrao);
		});

		return listaErrosPadraos;
	}

}
