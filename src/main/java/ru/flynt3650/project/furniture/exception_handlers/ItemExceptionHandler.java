package ru.flynt3650.project.furniture.exception_handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.flynt3650.project.furniture.util.ItemExceptionResponse;
import ru.flynt3650.project.furniture.util.exceptions.ItemNotFoundException;
import ru.flynt3650.project.furniture.util.exceptions.ItemNotPatchedException;
import ru.flynt3650.project.furniture.util.exceptions.ItemNotPostedException;

@ControllerAdvice
public class ItemExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ItemExceptionResponse> handleItemNotFoundException(ItemNotFoundException ex) {
        ItemExceptionResponse response = new ItemExceptionResponse(
                ex.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemNotPostedException.class)
    public ResponseEntity<ItemExceptionResponse> handleItemNotPostedException(ItemNotPostedException ex) {
        ItemExceptionResponse response = new ItemExceptionResponse(
                ex.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemNotPatchedException.class)
    public ResponseEntity<ItemExceptionResponse> handleItemNotPostedException(ItemNotPatchedException ex) {
        ItemExceptionResponse response = new ItemExceptionResponse(
                ex.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}