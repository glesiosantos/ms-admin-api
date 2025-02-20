package br.com.ohgestor.msadmin.api.web.handler;

import br.com.ohgestor.msadmin.api.web.responses.ErroResponse;
import br.com.ohgestor.msadmin.api.services.exceptions.ObjetoNaoEncontradoException;
import br.com.ohgestor.msadmin.api.web.responses.ErroValidacaoResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> error400(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(field ->  new ErroValidacaoResponse(field.getField(), field.getDefaultMessage())).toList());
    }

    @ExceptionHandler({ObjetoNaoEncontradoException.class})
    public ResponseEntity<?> errosCustomizado(Exception exception, HttpServletRequest request) {
        var error = new ErroResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), request.getServletPath());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler({HttpClientErrorException.class})
    public ResponseEntity<?> clientCustomException(Exception exception, HttpServletRequest request) {
        var error = new ErroResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), System.currentTimeMillis(), request.getServletPath());
        return ResponseEntity.badRequest().body(error);
    }

}
