package com.cmc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex){
        ApiError error=new ApiError(
                404,
                "Not Found",
                ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException ex){
        ApiError error=new ApiError(
                400,
                "Bad Request",
                ex.getMessage()
        );

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiError> handleConflict(ConflictException ex){
        ApiError error=new ApiError(
                409,
                "Conflict",
                ex.getMessage()
        );

        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex){
        String message= ex.getBindingResult().getFieldErrors().stream().findFirst().map(err->err.getField()+":"+err.getDefaultMessage()).orElse("Validation Error");
        ApiError error=new ApiError(
                400,
                "Validation Failed",
                message
        );
        return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }

}
