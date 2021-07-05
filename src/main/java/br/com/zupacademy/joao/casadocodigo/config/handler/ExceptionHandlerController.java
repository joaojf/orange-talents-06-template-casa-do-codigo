package br.com.zupacademy.joao.casadocodigo.config.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroPadrao> MethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ErroPadrao> erros = new ArrayList<>();

        exception.getGlobalErrors().forEach(objectError -> {
            erros.add(new ErroPadrao(objectError.getObjectName(), objectError.getDefaultMessage()));
        });

        exception.getFieldErrors().forEach(fieldError -> {
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            ErroPadrao erroDeValidacao = new ErroPadrao(fieldError.getField(), mensagem);
            erros.add(erroDeValidacao);
        });
        return erros;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ErroIdNaoEncontrado ObjectNotFoundException(ObjectNotFoundException exception){
        return new ErroIdNaoEncontrado(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

}
