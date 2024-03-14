package hu.preznyak.cmhfinances.web.exceptions;

public class CurrencyNotSupportedException extends RuntimeException {
    public CurrencyNotSupportedException(String message) {
        super(message);
    }
}
