package hu.preznyak.cmhfinances.web.controller;

import hu.preznyak.cmhfinances.web.exceptions.CurrencyNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(CurrencyNotSupportedException.class)
    public ResponseEntity<CurrencyNotSupportedException> currencyNotSupportedExceptionHandler(CurrencyNotSupportedException ex) {

        CurrencyNotSupportedException exception = new CurrencyNotSupportedException(ex.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
