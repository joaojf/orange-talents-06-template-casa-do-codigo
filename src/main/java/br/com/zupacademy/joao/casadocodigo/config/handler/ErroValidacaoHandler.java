package br.com.zupacademy.joao.casadocodigo.config.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> handle(MethodArgumentNotValidException exception) {
		List<String> globalErros = new ArrayList<>();

		if (exception.getBindingResult().hasFieldErrors()) {
			globalErros = exception.getBindingResult().getFieldErrors().stream().map(
					error -> error.getField() + ": " + messageSource.getMessage(error, LocaleContextHolder.getLocale()))
					.collect(Collectors.toList());
			return new ResponseEntity<List<String>>(globalErros, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(exception.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);

	}

}
