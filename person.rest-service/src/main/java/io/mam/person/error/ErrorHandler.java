package io.mam.person.error;

import io.mam.person.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PersonNotFound.class)
    public ResponseEntity<Response> personNotFoundAdvice(PersonNotFound personNotFound) {

        Response response = Response.builder()
                .responseCode("400")
                .responseDesc(personNotFound.getMessage())
                .personDto(null)
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
