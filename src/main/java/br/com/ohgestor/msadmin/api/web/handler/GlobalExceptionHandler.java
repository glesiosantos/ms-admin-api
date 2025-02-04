package br.com.ohgestor.msadmin.api.web.handler;

import br.com.ohgestor.msadmin.api.web.responses.ErroValidacaoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler({AccessDeniedException.class, UsernameNotFoundException.class})
    public ResponseEntity<?> accessDeniedException(Exception exception) {
        return ResponseEntity.badRequest().body("Acesso Negado");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> error400(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(field ->  new ErroValidacaoResponse(field.getField(), field.getDefaultMessage())).toList());
    }
}
