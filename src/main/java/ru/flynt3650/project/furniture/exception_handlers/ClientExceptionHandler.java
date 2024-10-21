package ru.flynt3650.project.furniture.exception_handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.flynt3650.project.furniture.util.ClientExceptionResponse;
import ru.flynt3650.project.furniture.util.exceptions.ClientNotPostedException;
import ru.flynt3650.project.furniture.util.exceptions.ClientNotFoundException;
import ru.flynt3650.project.furniture.util.exceptions.ClientNotPatchedException;

@ControllerAdvice
public class ClientExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ClientNotPostedException.class)
    public ResponseEntity<ClientExceptionResponse> handleClientNotAddedException(ClientNotPostedException ex) {
        ClientExceptionResponse response = new ClientExceptionResponse(
                ex.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ClientExceptionResponse> handleClientNotFoundException(ClientNotFoundException ex) {
        ClientExceptionResponse response = new ClientExceptionResponse(
                ex.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClientNotPatchedException.class)
    public ResponseEntity<ClientExceptionResponse> handleClientNotPatchedException(ClientNotPatchedException ex) {
        ClientExceptionResponse response = new ClientExceptionResponse(
                ex.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}