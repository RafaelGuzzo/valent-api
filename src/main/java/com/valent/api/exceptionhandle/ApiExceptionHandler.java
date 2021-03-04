package com.valent.api.exceptionhandle;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.valent.domain.exception.EntidadeNaoEncontradaException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> entidadeNaoEncontradaException(EntidadeNaoEncontradaException ex,
			WebRequest request) {
		var status = HttpStatus.NOT_FOUND;

		var problema = new Problema();
		problema.setStatus(status.value());
		problema.setDataHora(OffsetDateTime.now());
		problema.setTitulo(ex.getMessage());

		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
}
