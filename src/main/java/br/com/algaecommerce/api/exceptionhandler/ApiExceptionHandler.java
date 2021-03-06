package br.com.algaecommerce.api.exceptionhandler;

import br.com.algaecommerce.exception.MyEntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyEntityNotFoundException.class)
    public ResponseEntity<?> handleMyEntityNotFoundException(MyEntityNotFoundException e, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return handleExceptionInternal(
                e,
                null,
                new HttpHeaders(),
                HttpStatus.NOT_FOUND,
                request
        );
    }

}
