package com.refugee.exception;
import com.refugee.controller.HttpErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

@RestControllerAdvice
//operators that disputs the normal flow of the program to maintain a normal flow of our application
public class ExceptionHandler {
    //404 service not found
    @org.springframework.web.bind.annotation.ExceptionHandler(
            {PetNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HttpErrorResponse handleGenericException(PetNotFound exception){
        return new HttpErrorResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    //503 Service unavaliable
    @org.springframework.web.bind.annotation.ExceptionHandler(
            {ServiceNotAvaliable.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public HttpErrorResponse handleServiceNotAvailable(ServiceNotAvaliable exception){
        return new HttpErrorResponse(
                503,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}
