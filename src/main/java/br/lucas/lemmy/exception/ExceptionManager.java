package br.lucas.lemmy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

	@ExceptionHandler({NotFoundException.class})
	public ResponseEntity<ExceptionDTO> handleNotFoundException(Throwable exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(exception.getClass().getName(), exception.getMessage()));
	}
	
	@ExceptionHandler({BadRequestException.class})
	public ResponseEntity<ExceptionDTO> handleBadRequestException(Throwable exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(exception.getClass().getName(), exception.getMessage()));
	}
	
}
