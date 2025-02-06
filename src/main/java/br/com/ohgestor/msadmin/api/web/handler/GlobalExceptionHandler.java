package br.com.ohgestor.msadmin.api.web.handler;

import br.com.ohgestor.msadmin.api.web.responses.ErroValidacaoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> error400(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(field ->  new ErroValidacaoResponse(field.getField(), field.getDefaultMessage())).toList());
    }
}
